package com.javaexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CartDto;
import com.javaexpress.helper.CartMappingHelper;
import com.javaexpress.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartServiceImpl {

	@Autowired
	private CartRepository cartRepository;
	
	public CartDto save(CartDto cartDto) {
		log.info("CartServiceImpl :: save");
		return CartMappingHelper.map(
				cartRepository.save(
						CartMappingHelper.map(cartDto)));
	}
	
	// findbyId
}
