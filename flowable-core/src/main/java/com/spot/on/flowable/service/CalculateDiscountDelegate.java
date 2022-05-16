package com.spot.on.flowable.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.spot.on.flowable.ProcessVariables.*;

@Component
public class CalculateDiscountDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution delegateExecution) {
		int totalPriceInCents = (int) delegateExecution.getVariable(TOTAL_PRICE_IN_CENTS.getValue());
		double tax = (double) delegateExecution.getVariable(PRODUCTS_TAX.getValue());

		long taxValue = (long) (totalPriceInCents * tax / 100);
		delegateExecution.setVariable(TAX_VALUE_FOR_PRODUCTS.getValue(), taxValue);
	}

}
