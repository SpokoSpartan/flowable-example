package com.spot.on.flowable.controller;


import com.spot.on.flowable.api.PurchaseProductCommand;
import com.spot.on.flowable.service.StartPurchaseProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class PurchaseProductController {

	private final StartPurchaseProcessService service;

	@PostMapping("/purchase")
	public String purchaseProduct(@RequestBody PurchaseProductCommand command) {
		return service.startProcess(command);
	}

}
