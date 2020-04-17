package com.ECommerce.controller;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ECommerce.Dto.ProductDto;
import com.ECommerce.converter.ProductConverter;
import com.ECommerce.model.Product;
import com.ECommerce.service.ProductServiceImpl;
import com.ECommerce.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.PRODUCT)
public class ProductController {
	
	private ProductServiceImpl productService;
	private ProductConverter productConverter;
	
    @GetMapping("/")
    public @NotNull Iterable<ProductDto> getProducts() {
        return productConverter.entityListToDtoList((Collection<Product>) productService.getAllProducts());
    }
    
    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable(value = "id") long id) {
    	return productConverter.entityToDto(productService.getProduct(id));
    }
    
    @PostMapping("/")
    public ProductDto createProduct(@Valid @RequestBody ProductDto prodDto) {
    	return productConverter.entityToDto(productService.saveProduct(prodDto));
    }
    

}
