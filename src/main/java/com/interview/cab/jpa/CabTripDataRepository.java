package com.interview.cab.jpa;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.interview.cab.entity.CabTripEntity;

/**
 * Repository class to fetch data from cab_trip_data table
 *
 * @author Krupa N
 */
public interface CabTripDataRepository extends CrudRepository<CabTripEntity, String> {

    @Query("select Count(c) from CabTripEntity c where c.medallion = ?1 and c.pickupDatetime >= ?2 and pickupDatetime < ?3")
    int findCountByCabIdAndPickupDate(String cabId, LocalDate pickUpDateStart, LocalDate pickUpDateEnd);
}