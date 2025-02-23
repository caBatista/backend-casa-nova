package com.casa.nova.model;

import com.casa.nova.dto.ProductUpRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double price;
	
	private String imageUrl;
	
	@Builder.Default
	private boolean active = true;
	
	public void update(ProductUpRequest product) {
		if(product.name() != null) {
			this.name = product.name();
		}
		if(product.description() != null) {
			this.description = product.description();
		}
		if(product.price() != null) {
			this.price = product.price();
		}
		if(product.imageUrl() != null) {
			this.imageUrl = product.imageUrl();
		}
	}
	
	public void delete(){
		this.active = false;
	}
}
