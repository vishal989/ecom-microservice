package com.javaexpress.helpers;

import org.springframework.beans.BeanUtils;

import com.javaexpress.dtos.FavouriteDto;
import com.javaexpress.models.Favourite;
import com.javaexpress.models.FavouriteId;

public interface FavouriteHelper {

	static Favourite map(FavouriteDto favouriteDto) {
		FavouriteId favouriteId = new FavouriteId();
		BeanUtils.copyProperties(favouriteDto, favouriteId);
		Favourite favourite = new Favourite();
		favourite.setId(favouriteId);
		return favourite;
	}
	
	
	static FavouriteDto map(Favourite favourite) {
		FavouriteId favouriteId = favourite.getId();
		FavouriteDto favouriteDto = new FavouriteDto();
		BeanUtils.copyProperties(favouriteId, favouriteDto);
		return favouriteDto;
	}
}
