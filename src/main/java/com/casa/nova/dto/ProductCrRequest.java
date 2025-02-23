package com.casa.nova.dto;

import com.casa.nova.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCrRequest(
	@NotBlank
	String name,
	@NotBlank
	String description,
	@NotNull
	Double price,
	@NotBlank
	String imageUrl
) {
	public Product toModel(){
		var product = Product.builder()
				.name(this.name())
				.description(this.description())
				.price(this.price())
				.imageUrl(this.imageUrl())
				.build();
		
		return product;
	}
}