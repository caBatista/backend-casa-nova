package com.casa.nova.dto;

import com.casa.nova.model.Product;
import jakarta.validation.constraints.NotNull;

public record ProductUpRequest(
	@NotNull
	Long id,
	String name,
	String description,
	Double price,
	String imageUrl,
	String marketplaceUrl
) {}