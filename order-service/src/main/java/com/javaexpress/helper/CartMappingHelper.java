package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CartDto;
import com.javaexpress.model.Cart;

public interface CartMappingHelper {

	// Method references alternative for lambda expression
	// db to frontend
	public static CartDto map(Cart cart) {
		CartDto cartDto = new CartDto();
		BeanUtils.copyProperties(cart, cartDto);
		// will add userdto logic later
		return cartDto;
	}
	
	// frontend to db
	public static Cart map(CartDto cartDto) {
		Cart cart = new Cart();
		BeanUtils.copyProperties(cartDto, cart);
		return cart;
	}
}
