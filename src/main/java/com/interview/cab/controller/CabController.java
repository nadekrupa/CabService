package com.interview.cab.controller;

import static org.springframework.util.StringUtils.isEmpty;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.interview.cab.jpa.CabTripDataRepository;
import com.interview.cab.request.TripRequest;
import com.interview.cab.request.TripResuestInfo;
import com.interview.cab.response.ClearCacheResponse;
import com.interview.cab.response.TripInfo;
import com.interview.cab.response.TripResponse;

/**
 * Cab Controller class
 *
 * @author Krupa N
 */
@RestController
public class CabController {

	private final Logger logger = LoggerFactory.getLogger(CabController.class);

	@Autowired
	private CabTripDataRepository repo;

	LoadingCache<TripResuestInfo, Integer> cache = CacheBuilder.newBuilder().maximumSize(1000) // maximum 1000 records
																								// can be cached
			.expireAfterAccess(5, TimeUnit.MINUTES) // cache will expire after 5 minutes of access
			.build(new CacheLoader<TripResuestInfo, Integer>() { // build the cacheloader

				@Override
				public Integer load(TripResuestInfo info) throws Exception {
					// make the expensive call
					return getFromDatabase(info);
				}
			});

	@PostMapping(path = "/1/fetch/trip-info")
	public TripResponse getTripInfo(@RequestBody TripRequest request, @RequestParam boolean useCache)
			throws ExecutionException {
		validateRequest(request);
		TripResponse response = new TripResponse();

		for (TripResuestInfo tripInfo : request.getTripRequests()) {
			int tripCount;

			if (useCache) {
				tripCount = cache.get(tripInfo);
			} else {
				tripCount = getFromDatabase(tripInfo);
				// update result in cache
				cache.put(tripInfo, tripCount);
			}

			TripInfo info = new TripInfo(tripInfo.getCabId(), tripInfo.getPickupDate(), tripCount);
			response.getTripInfos().add(info);
		}

		return response;
	}

	@GetMapping(path = "/1/cache/clear")
	public ClearCacheResponse clearCache() {
		logger.info("Clearing cache");
		cache.invalidateAll();
		return new ClearCacheResponse("SUCCESS");
	}

	private void validateRequest(TripRequest request) {
		if (request == null || CollectionUtils.isEmpty(request.getTripRequests())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
		}

		request.getTripRequests().forEach(trip -> {
			if (isEmpty(trip.getCabId())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cab id is missing in the request");
			}
		});
	}

	/**
	 * Fetches data from DB
	 * 
	 * @param info - request
	 * @return
	 */
	private int getFromDatabase(TripResuestInfo info) {
		LocalDate pickupDate = info.getPickupDate();
		logger.info("Fetching data from DB. Cab ID: {}, pickup date = {}", info.getCabId(), pickupDate);

		int count = repo.findCountByCabIdAndPickupDate(info.getCabId(), pickupDate, pickupDate.plusDays(1));

		logger.info("Got response from DB. Cab ID: {}, pickup date = {}, Trip count = {}", info.getCabId(), pickupDate,
				count);

		return count;
	}
}