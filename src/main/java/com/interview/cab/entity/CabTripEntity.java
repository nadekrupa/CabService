package com.interview.cab.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class representing cab_trip_data table
 *
 * @author Krupa N
 */
@Entity
@Table(name = "cab_trip_data")
public class CabTripEntity {
	@Id
	@Column(name = "medallion", unique = false, nullable = true)
	private String medallion;
	
	private String hackLicense;
	
	private String vendorId;
	
	private int rateCode;
	
	private String storeAndFwdFlag;
	
	@Column(name = "pickup_datetime", columnDefinition = "TIMESTAMP")
	private LocalDate pickupDatetime;
	
	@Column(name = "dropoff_datetime", columnDefinition = "TIMESTAMP")
	private LocalDate dropoffDatetime;
	
	private int passengerCount;
	
	private int tripTimeInSecs;
	
	private Double tripDistance;
	
	private Double pickupLongitude;
	
	private Double pickupLatitude;
	
	private Double dropoffLongitude;
	
	private Double dropoffLatitude;

	public CabTripEntity() {
	}

	public String getMedallion() {
		return medallion;
	}

	public void setMedallion(String medallion) {
		this.medallion = medallion;
	}

	public String getHackLicense() {
		return hackLicense;
	}

	public void setHackLicense(String hackLicense) {
		this.hackLicense = hackLicense;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public int getRateCode() {
		return rateCode;
	}

	public void setRateCode(int rateCode) {
		this.rateCode = rateCode;
	}

	public String getStoreAndFwdFlag() {
		return storeAndFwdFlag;
	}

	public void setStoreAndFwdFlag(String storeAndFwdFlag) {
		this.storeAndFwdFlag = storeAndFwdFlag;
	}

	public LocalDate getPickupDatetime() {
		return pickupDatetime;
	}

	public void setPickupDatetime(LocalDate pickupDatetime) {
		this.pickupDatetime = pickupDatetime;
	}

	public LocalDate getDropoffDatetime() {
		return dropoffDatetime;
	}

	public void setDropoffDatetime(LocalDate dropoffDatetime) {
		this.dropoffDatetime = dropoffDatetime;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public int getTripTimeInSecs() {
		return tripTimeInSecs;
	}

	public void setTripTimeInSecs(int tripTimeInSecs) {
		this.tripTimeInSecs = tripTimeInSecs;
	}

	public Double getTripDistance() {
		return tripDistance;
	}

	public void setTripDistance(Double tripDistance) {
		this.tripDistance = tripDistance;
	}

	public Double getPickupLongitude() {
		return pickupLongitude;
	}

	public void setPickupLongitude(Double pickupLongitude) {
		this.pickupLongitude = pickupLongitude;
	}

	public Double getPickupLatitude() {
		return pickupLatitude;
	}

	public void setPickupLatitude(Double pickupLatitude) {
		this.pickupLatitude = pickupLatitude;
	}

	public Double getDropoffLongitude() {
		return dropoffLongitude;
	}

	public void setDropoffLongitude(Double dropoffLongitude) {
		this.dropoffLongitude = dropoffLongitude;
	}

	public Double getDropoffLatitude() {
		return dropoffLatitude;
	}

	public void setDropoffLatitude(Double dropoffLatitude) {
		this.dropoffLatitude = dropoffLatitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dropoffDatetime, dropoffLatitude, dropoffLongitude, hackLicense, medallion, passengerCount,
				pickupDatetime, pickupLatitude, pickupLongitude, rateCode, storeAndFwdFlag, tripDistance,
				tripTimeInSecs, vendorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CabTripEntity other = (CabTripEntity) obj;
		return Objects.equals(dropoffDatetime, other.dropoffDatetime)
				&& Objects.equals(dropoffLatitude, other.dropoffLatitude)
				&& Objects.equals(dropoffLongitude, other.dropoffLongitude)
				&& Objects.equals(hackLicense, other.hackLicense) && Objects.equals(medallion, other.medallion)
				&& passengerCount == other.passengerCount && Objects.equals(pickupDatetime, other.pickupDatetime)
				&& Objects.equals(pickupLatitude, other.pickupLatitude)
				&& Objects.equals(pickupLongitude, other.pickupLongitude) && rateCode == other.rateCode
				&& Objects.equals(storeAndFwdFlag, other.storeAndFwdFlag)
				&& Objects.equals(tripDistance, other.tripDistance) && tripTimeInSecs == other.tripTimeInSecs
				&& Objects.equals(vendorId, other.vendorId);
	}
}
