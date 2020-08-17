package com.interview.cab.request;

import java.time.LocalDate;
import java.util.Objects;

/**
 *  Class representing a trip entry in request body of /1/fetch/trip-info api
 *
 * @author Krupa N
 */
public class TripResuestInfo {

	private String cabId;

	private LocalDate pickupDate;

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

	@Override
	public int hashCode() {
		return Objects.hash(cabId, pickupDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripResuestInfo other = (TripResuestInfo) obj;
		return Objects.equals(cabId, other.cabId) && Objects.equals(pickupDate, other.pickupDate);
	}
}
