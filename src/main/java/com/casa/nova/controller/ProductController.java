package com.casa.nova.controller;

import com.casa.nova.dto.ProductCrRequest;
import com.casa.nova.dto.ProductResponse;
import com.casa.nova.dto.ProductUpRequest;
import com.casa.nova.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping()
	public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductCrRequest productCrRequest) {
		var response = productService.create(productCrRequest);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getProducts(){
		var products = productService.findAll();
		
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/{id}")
	public ProductResponse getProductById(@PathVariable Long id) {
		return productService.findById(id);
	}
	
	@PutMapping()
	public ResponseEntity<ProductResponse> updateProduct(@RequestBody @Valid ProductUpRequest productUpRequest) {
		var response = productService.update(productUpRequest);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteProduct(@PathVariable Long id) {
		productService.delete(id);
		
		return ResponseEntity.ok().build();
	}
}
