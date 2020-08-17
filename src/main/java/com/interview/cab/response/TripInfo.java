package com.interview.cab.response;

import java.time.LocalDate;

/**
 *  Class representing trip info in response of /1/fetch/trip-info api
 *
 * @author Krupa N
 */
public class TripInfo {
	private String cabId;
	private LocalDate pickupDate;
	private int tripCount;
	
	public TripInfo() {
		
	}

	public TripInfo(String cabId, LocalDate pickupDate, int tripCount) {
		super();
		this.cabId = cabId;
		this.pickupDate = pickupDate;
		this.tripCount = tripCount;
	}

	public String getCabId() {
		return cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public int getTripCount() {
		return tripCount;
	}

	public void setTripCount(int tripCount) {
		this.tripCount = tripCount;
	}

}
