package com.order.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.order.service.util.OfferType;
@Entity
public class Offer {
	@Id
	@GeneratedValue
	private int offerId;
	private String offerName;
	private OfferType offerType;
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public OfferType getOfferType() {
		return offerType;
	}
	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}
	
	

}
