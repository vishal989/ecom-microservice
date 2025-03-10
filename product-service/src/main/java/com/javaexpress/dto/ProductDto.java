package com.javaexpress.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

	private Integer productId;

	private String productTitle;

	private String sku;

	private Double priceUnit;

	private Integer quantity;

	@JsonProperty("category")
	private CategoryDto categoryDto;
}
