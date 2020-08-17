package com.interview.cab.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.interview.cab.entity.CabTripEntity;

@Transactional
@SpringBootTest
class CabTripDataRepositoryTest {

	@Autowired
	private CabTripDataRepository repo;
	
	@Test
	public void shouldReturnAValueIfMatchingCriteriaIsProvided() {

		//given
		CabTripEntity data = new CabTripEntity();
		data.setMedallion("test");
		LocalDate now = LocalDate.now();
		data.setPickupDatetime(now);

		//when
		data = repo.save(data);

		//then
		int count = repo.findCountByCabIdAndPickupDate("test", now, now.plusDays(1));
		assertEquals(1, count);
	}
	
	@Test
	public void shouldNotReturnAnyValueIfDiffrentDateIsProvided() {

		//given
		CabTripEntity data = new CabTripEntity();
		data.setMedallion("test");
		LocalDate now = LocalDate.now();
		data.setPickupDatetime(now);

		//when
		data = repo.save(data);

		//then
		int count = repo.findCountByCabIdAndPickupDate("test", now.minusDays(1), now);
		assertEquals(0, count);
	}

}
