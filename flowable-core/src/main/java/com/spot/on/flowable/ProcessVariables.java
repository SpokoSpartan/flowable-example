package com.spot.on.flowable;


public enum ProcessVariables {

	PRODUCT_NAME("ProductName"),
	PRODUCT_CATEGORY("ProductCategory"),
	PRODUCT_PRICE_IN_CENTS("ProductPriceInCents"),
	IS_ORDER_ACTIVE("IsOrderActive"),
	PURCHASED_PRODUCTS_AMOUNT("PurchasedProductAmount"),
	TOTAL_PRICE_IN_CENTS("TotalPriceInCents"),
	PRODUCTS_TAX("ProductsTax"),
	TAX_VALUE_FOR_PRODUCTS("TaxValueForProducts");

	final String value;
	ProcessVariables(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
