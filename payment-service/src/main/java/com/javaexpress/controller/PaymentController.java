package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.PaymentDto;
import com.javaexpress.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/payments")
@Slf4j
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public PaymentDto save(@RequestBody PaymentDto paymentDto) {
		log.info("PaymentController save");
		return paymentService.save(paymentDto);
	}
	
	@PutMapping("{paymentId}")
	public PaymentDto update(@PathVariable Integer paymentId,@RequestBody PaymentDto paymentDto) {
		log.info("PaymentController update");
		return paymentService.update(paymentId,paymentDto);
	}
	
 }
