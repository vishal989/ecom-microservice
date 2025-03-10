package com.javaexpress.helper;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.models.Category;

public interface CategoryMappingHelper {

	// frontend to database
	public static Category map(CategoryDto categoryDto) {
		Category category = new Category();
		BeanUtils.copyProperties(categoryDto, category);
		
		if(categoryDto.getParentCategoryDto() != null) {
			Category parentCategory = new Category();
			parentCategory.setCategoryId(categoryDto.getParentCategoryDto().getCategoryId());
			category.setParentCategory(parentCategory);
		} else {
			category.setParentCategory(null);
		}
		
		return category;
	}
	
	// database to frontend
	public static CategoryDto map(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		BeanUtils.copyProperties(category, categoryDto);
		
		if(category.getParentCategory()!=null) {
			CategoryDto parenCategoryDto = new CategoryDto();
			BeanUtils.copyProperties(category.getParentCategory(), parenCategoryDto);
			categoryDto.setParentCategoryDto(parenCategoryDto);
		}
		return categoryDto;
	}
}
