package com.axis.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.entity.Product;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidPriceException;
import com.axis.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
	ProductRepository productRepository;
	@Override
	public Product addProduct(Product product) throws InValidPriceException {
		
		if(product.getPrice()<=100)
			throw new InValidPriceException("Minimum Price Should be more than Rs.100/-");
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) throws IdNotFoundException {
		Optional<Product> prod = productRepository.findById(id);
		if(prod.isPresent())
		return prod.get();
		else
			throw new IdNotFoundException("No Id present to get the value");
	}

	@Override
	public Product updateProductById(int id, Product product) throws IdNotFoundException {
		Optional<Product> prod = productRepository.findById(id);
		if(prod.isPresent())
		return productRepository.save(product);
		else
			throw new IdNotFoundException("No Id present to update");
	}

	@Override
	public String deleteProductById(int id) throws IdNotFoundException {
		Optional<Product> prod = productRepository.findById(id);
		if(prod.isPresent()) {
			productRepository.deleteById(id);
		return "product deleted";
		}
		else
			throw new IdNotFoundException("No Id present to delete");
	}

	
			
	
	}

	
	

