package com.axis.service;

import java.util.List;

import com.axis.entity.Product;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidPriceException;

public interface ProductService {
   
	Product addProduct(Product product) throws InValidPriceException;
	List<Product> getAllProducts();
	Product getProductById(int id) throws IdNotFoundException;
	Product updateProductById(int id,Product product) throws IdNotFoundException;
	String deleteProductById(int id) throws IdNotFoundException;

}
