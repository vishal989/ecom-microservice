package com.javaexpress.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaexpress.models.Category;
import com.javaexpress.models.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

	private Integer categoryId; //
	
	private String categoryTitle; // Electornics
	
	private Set<CategoryDto> subCategoriesDto;
	
	@JsonProperty("parentCategory")
	private CategoryDto parentCategoryDto; // id 3 4 3 
	
	private Set<ProductDto> productsDtos;
}
