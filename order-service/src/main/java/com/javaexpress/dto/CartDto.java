package com.javaexpress.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartDto {

	private Integer cartId;
	
	private Integer userId;
	
	private List<OrderDto> ordersDto;
	
	// later will add userdto
	
}
