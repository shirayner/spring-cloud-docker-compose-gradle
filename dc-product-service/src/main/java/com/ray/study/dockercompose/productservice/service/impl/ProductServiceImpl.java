package com.ray.study.dockercompose.productservice.service.impl;

import com.ray.study.dockercompose.dcmodel.entity.product.Product;
import com.ray.study.dockercompose.productservice.repository.ProductRepository;
import com.ray.study.dockercompose.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductServiceImpl
 *
 * @author shira 2019/06/04 14:27
 */
@Service
public class ProductServiceImpl implements ProductService {

	ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository){
		this.productRepository = productRepository;
	}


	@Override
	public List<Product> list() {
		return productRepository.findAll();
	}

	@Override
	public Product query(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		return productOptional.orElse(null);
	}

	@Override
	public Product insert(Product user) {
		return productRepository.save(user);
	}

	@Override
	public Product update(Product user) {
		return productRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
}
