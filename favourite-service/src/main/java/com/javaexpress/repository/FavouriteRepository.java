package com.javaexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.models.Favourite;
import com.javaexpress.models.FavouriteId;

public interface FavouriteRepository  extends JpaRepository<Favourite, FavouriteId>{

}
