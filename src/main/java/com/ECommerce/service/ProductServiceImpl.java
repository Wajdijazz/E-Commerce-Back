package com.ECommerce.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ECommerce.Dto.ProductDto;
import com.ECommerce.converter.ProductConverter;
import com.ECommerce.dao.ProductRepository;
import com.ECommerce.exception.ResourceNotFoundException;
import com.ECommerce.model.Product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class ProductServiceImpl {

	private ProductRepository productRepository;
	private ProductConverter productConverter;

	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProduct(long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	public Product saveProduct(ProductDto productDto) {
		return productRepository.save(productConverter.dtoToEntity(productDto));
	}

}
