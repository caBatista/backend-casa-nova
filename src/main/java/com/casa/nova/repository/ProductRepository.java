package com.casa.nova.repository;

import com.casa.nova.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByActiveTrue();
}
