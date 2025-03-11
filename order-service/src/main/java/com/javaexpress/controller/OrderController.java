package com.javaexpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.dto.OrderDto;
import com.javaexpress.service.OrderServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {

	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public OrderDto save(@RequestBody OrderDto orderDto) {
		return orderServiceImpl.save(orderDto);
	}
}
