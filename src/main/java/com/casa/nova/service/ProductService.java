package com.casa.nova.service;

import com.casa.nova.dto.ProductCrRequest;
import com.casa.nova.dto.ProductResponse;
import com.casa.nova.dto.ProductUpRequest;
import com.casa.nova.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public ProductResponse create(ProductCrRequest productCrRequest) {
		var product = productRepository.save(productCrRequest.toModel());
		
		return new ProductResponse(product);
	}
	
	public List<ProductResponse> findAll() {
		var products = productRepository.findByActiveTrue();
		
		return products.stream()
				.map(ProductResponse :: new)
				.toList();
	}
	
	public ProductResponse findById(Long id) {
		var product = productRepository.findById(id).orElseThrow();
		
		return new ProductResponse(product);
	}
	
	public ProductResponse update(ProductUpRequest productUpRequest) {
		var productToUpdate = productRepository.findById(productUpRequest.id()).orElseThrow();
		
		productToUpdate.update(productUpRequest);
		
		var updatedProduct = productRepository.save(productToUpdate);
		
		return new ProductResponse(updatedProduct);
	}
	
	public void delete(Long id) {
		var productToDelete = productRepository.findById(id).orElseThrow();
		
		productToDelete.delete();
		
		productRepository.save(productToDelete);
	}
}
