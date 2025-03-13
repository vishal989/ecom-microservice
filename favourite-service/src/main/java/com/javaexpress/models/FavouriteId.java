package com.javaexpress.models;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FavouriteId {

	private Integer userId;
	private Integer productId;
	private LocalDateTime likedDate;
	
}
