package com.casa.nova.dto;

import com.casa.nova.model.Product;

public record ProductResponse(
	Long id,
	String name,
	String description,
	Double price,
	String imageUrl
) {
	public ProductResponse(Product product) {
		this(
				product.getId(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				product.getImageUrl()
		);
	}
}
