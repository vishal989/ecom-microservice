package com.javaexpress.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.CategoryDto;
import com.javaexpress.helper.CategoryMappingHelper;
import com.javaexpress.models.Category;
import com.javaexpress.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	// 1) Electornics in db - 561
	//  2) iphone - parent category id 561
	public CategoryDto save(CategoryDto categoryDto) {
		log.info("CategoryService save");
		// parentcategory we will store
		// subcategory we will store
		Category parentCategory = null;
		
		if(categoryDto.getParentCategoryDto()!= null) {
			// Electronics 1
			Integer id = categoryDto.getParentCategoryDto().getCategoryId();
			parentCategory = categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Parent Category Not Found"));
		}
		
		Category category = CategoryMappingHelper.map(categoryDto);
		if(parentCategory != null) {
			// 561 electonics setting in iphone 11
			category.setParentCategory(parentCategory);
		}
		
		Category dbCategory = categoryRepository.save(category);
		return CategoryMappingHelper.map(dbCategory);
	}
	
	public List<CategoryDto> findAll() {
		return categoryRepository.findAll()
				.stream()
				.map(CategoryMappingHelper::map)
				.distinct()
				.collect(Collectors.toList());
	}
	
}
