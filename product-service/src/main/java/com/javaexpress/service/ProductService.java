package com.javaexpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.ProductDto;
import com.javaexpress.helper.ProductMappingHelper;
import com.javaexpress.models.Product;
import com.javaexpress.repository.CategoryRepository;
import com.javaexpress.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public ProductDto save(ProductDto productDto) {
		log.info("ProductService save ");
		Product product = ProductMappingHelper.map(productDto);
		var dbCategory = categoryRepository.findById(productDto.getCategoryDto().getCategoryId())
						.orElseThrow(() -> new RuntimeException("Category Not Found in Db"));
		// 
		product.setCategory(dbCategory); 
		Product dbProduct = productRepository.save(product);
		return ProductMappingHelper.map(dbProduct);
	}
}
