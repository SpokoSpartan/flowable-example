package com.spot.on.flowable.service;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class DummyDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution delegateExecution) {
		log.info("Dummy delegate executed!");
	}

}
