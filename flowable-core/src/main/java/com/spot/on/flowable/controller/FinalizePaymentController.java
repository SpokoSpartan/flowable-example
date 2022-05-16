package com.spot.on.flowable.controller;

import com.spot.on.flowable.service.FinalizePaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class FinalizePaymentController {

	private final FinalizePaymentService service;

	@PostMapping("/purchase/{processId}")
	public void purchaseProduct(@PathVariable String processId) {
		service.finalizePayment(processId);
	}

}
