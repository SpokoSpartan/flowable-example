package com.spot.on.flowable.service;

import lombok.RequiredArgsConstructor;
import org.flowable.engine.RuntimeService;
import org.flowable.eventsubscription.api.EventSubscription;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FinalizePaymentService {

	private static final String EVENT_TYPE = "wait-for-payment";

	private final RuntimeService runtimeService;

	public void finalizePayment(String processId) {
		runtimeService.trigger(getEventSubscription(processId).getExecutionId());
	}

	private EventSubscription getEventSubscription(String processId) {
		return runtimeService.createEventSubscriptionQuery()
				.processInstanceId(processId)
				.eventType(EVENT_TYPE)
				.singleResult();
	}

}
