package com.javaexpress.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum PaymentStatus {

	NOT_STARTED,
	IN_PROGRESS,
	COMPLETED,
	FAILURE;
	
	private String status;
	
}
