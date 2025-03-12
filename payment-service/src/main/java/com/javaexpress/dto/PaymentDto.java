package com.javaexpress.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaexpress.model.PaymentStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PaymentDto {

	private Integer paymentId;

	private Integer orderId;

	private Boolean isPayed;

	private PaymentStatus paymentStatus;
	
	//@JsonProperty("order")
	//private OrderDto orderDto;
}
