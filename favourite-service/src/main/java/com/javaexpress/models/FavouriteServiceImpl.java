package com.javaexpress.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dtos.FavouriteDto;
import com.javaexpress.helpers.FavouriteHelper;
import com.javaexpress.repository.FavouriteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FavouriteServiceImpl {

	@Autowired
	private FavouriteRepository favouriteRepository;
	
	public FavouriteDto save(FavouriteDto favouriteDto) {
		log.info("FavouriteServiceImpl save");
		Favourite favourite = FavouriteHelper.map(favouriteDto);
		Favourite dbfavourite = favouriteRepository.save(favourite);
		return FavouriteHelper.map(dbfavourite);
	}
	
}
