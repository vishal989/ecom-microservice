package com.javaexpress.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.OrderDto;
import com.javaexpress.helper.OrderMappingHelper;
import com.javaexpress.model.Cart;
import com.javaexpress.model.Order;
import com.javaexpress.repository.CartRepository;
import com.javaexpress.repository.OrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	public OrderDto save(OrderDto orderDto) {
		log.info("OrderServiceImpl save");
		orderDto.setOrderDateTime(LocalDateTime.now());
		Cart dbCart = cartRepository.findById
			(orderDto.getCartDto().getCartId())
				.orElseThrow(() -> new RuntimeException("Invalid CartId"));
		
		Order order = OrderMappingHelper.map(orderDto);
		order.setCart(dbCart);
		
		Order dbOrder = orderRepository.save(order);
		return OrderMappingHelper.map(dbOrder);
	}
	
	// findById
}
