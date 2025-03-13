package com.javaexpress.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="favourites")
@Data
public class Favourite {

	@EmbeddedId
	private FavouriteId id;
}
