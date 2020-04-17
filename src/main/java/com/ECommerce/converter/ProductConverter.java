package com.ECommerce.converter;

import org.springframework.stereotype.Component;

import com.ECommerce.Dto.ProductDto;
import com.ECommerce.model.Product;

@Component
public class ProductConverter implements GenericsConverter<Product, ProductDto> {

	@Override
	public ProductDto entityToDto(Product product) {
		// TODO Auto-generated method stub
		return ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.pictureUrl(product.getPictureUrl())
				.price(product.getPrice())
				.build();
	}

	@Override
	public Product dtoToEntity(ProductDto productDto) {
		// TODO Auto-generated method stub
		return Product.builder()
				.id(productDto.getId())
				.name(productDto.getName())
				.pictureUrl(productDto.getPictureUrl())
				.price(productDto.getPrice())
				.build();
	}

}
