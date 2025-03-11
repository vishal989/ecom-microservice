package com.javaexpress.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDto {

	private Integer orderId;
	
	private LocalDateTime orderDateTime; 
	
	private String orderDesc;
	
	private double orderFee;
	
	@JsonProperty("cart")
	private CartDto cartDto;
	
//	private Integer userId;
}
