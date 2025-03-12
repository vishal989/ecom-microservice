package com.javaexpress.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OrderDto {

	private Integer orderId;
	
	private LocalDateTime orderDate;
	
	private String orderDesc;
	
	private double orderFee;
}
