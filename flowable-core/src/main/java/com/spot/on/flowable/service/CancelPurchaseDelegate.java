package com.spot.on.flowable.service;

import org.flowable.common.engine.api.async.AsyncTaskInvoker;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.FutureJavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.spot.on.flowable.ProcessVariables.IS_ORDER_ACTIVE;

@Component
public class CancelPurchaseDelegate implements FutureJavaDelegate<Map<String, Object>> {

	@Override
	public CompletableFuture<Map<String, Object>> execute(DelegateExecution delegateExecution, AsyncTaskInvoker taskInvoker) {
		return taskInvoker.submit(() -> {
			wait(30);
			return Map.of(IS_ORDER_ACTIVE.getValue(), false);
		});
	}

	private void wait(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}

	@Override
	public void afterExecution(DelegateExecution delegateExecution, Map<String, Object> newVariables) {
		delegateExecution.setVariables(newVariables);
	}

}
