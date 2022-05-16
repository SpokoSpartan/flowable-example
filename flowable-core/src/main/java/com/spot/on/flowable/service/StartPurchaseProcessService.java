package com.spot.on.flowable.service;

import com.spot.on.flowable.api.PurchaseProductCommand;
import lombok.RequiredArgsConstructor;
import org.flowable.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.spot.on.flowable.ProcessVariables.*;

@Service
@RequiredArgsConstructor
public class StartPurchaseProcessService {

	private static final String PROCESS_DEFINITION_KEY = "ProductPurchase";

	private final RuntimeService runtimeService;

	public String startProcess(PurchaseProductCommand command) {
		return runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, prepareVariables(command))
				.getProcessInstanceId();
	}

	private Map<String, Object> prepareVariables(PurchaseProductCommand command) {
		return Map.of(
				PRODUCT_NAME.getValue(), command.getProductName(),
				PRODUCT_CATEGORY.getValue(), command.getCategory(),
				PRODUCT_PRICE_IN_CENTS.getValue(), command.getPriceInCents(),
				PURCHASED_PRODUCTS_AMOUNT.getValue(), command.getAmount()
		);
	}

}
