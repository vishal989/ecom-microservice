package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.dto.ProductDto;
import com.javaexpress.models.Category;
import com.javaexpress.models.Product;

public interface ProductMappingHelper {

	public static Product map(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		
		Category category = new Category();
		category.setCategoryId(productDto.getCategoryDto().getCategoryId());
		product.setCategory(category);
		
		return product;
	}
	
	public static ProductDto map(Product product) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		
		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(product.getCategory(), categoryDto);
		productDto.setCategoryDto(categoryDto);
		
		return productDto;
	}
	
}
