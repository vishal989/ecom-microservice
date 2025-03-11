package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CartDto;
import com.javaexpress.dto.OrderDto;
import com.javaexpress.model.Order;

public interface OrderMappingHelper {

	public static OrderDto map(Order order) {
		OrderDto orderDto = new OrderDto();
		BeanUtils.copyProperties(order, orderDto);
		
		if(order.getCart() != null) {
			CartDto cartDto = new CartDto();
			BeanUtils.copyProperties(order.getCart(), cartDto);
			orderDto.setCartDto(cartDto);
		}
		return orderDto;
	}
	
	public static Order map(OrderDto orderDto) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDto, order);
//		if(orderDto.getCartDto() != null) {
//			Cart cart = new Cart();
//			BeanUtils.copyProperties(orderDto.getCartDto(), cart);
//			order.setCart(cart);
//		}
		return order;
	}
	
}
