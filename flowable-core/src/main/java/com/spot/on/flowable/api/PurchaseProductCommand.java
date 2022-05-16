package com.spot.on.flowable.api;


import lombok.Value;

@Value
public class PurchaseProductCommand {

	int amount;
	String productName;
	ProductCategory category;
	long priceInCents;

	public enum ProductCategory {
		DRINK,
		FOOD,
		ALCOHOL
	}

}
