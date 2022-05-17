package com.spot.on.flowableadapter.workers;

import com.xti.flowable.client.AcquiredJob;
import com.xti.flowable.client.annotation.FlowableWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrepareInvoiceWorker {

	@FlowableWorker(topic="prepare-invoice", lockDuration = "PT1M")
	public void execute(AcquiredJob job) {
		job.getVariables().forEach(
				engineVariable -> {
					log.info(engineVariable.getName() + ": " + engineVariable.getValue());
				}
		);
		// czy da się JSON'a?
		job.complete();
	}

}
