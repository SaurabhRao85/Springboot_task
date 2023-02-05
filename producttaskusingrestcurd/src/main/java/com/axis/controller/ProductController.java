package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Product;
import com.axis.exception.IdNotFoundException;
import com.axis.exception.InValidPriceException;
import com.axis.service.ProductService;

@RestController
@RequestMapping("api/v1")
public class ProductController {


	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody  Product product) throws InValidPriceException
	{
		return productService.addProduct(product);
	}
	
	@GetMapping("/product")
	public List<Product> getAllProduct()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) throws IdNotFoundException
	{
		return productService.getProductById(id);
	}
	
	
	@PutMapping("/product/{id}")
	public Product updateProductById(@PathVariable int id,@RequestBody Product product) throws IdNotFoundException
	{
	  return productService.updateProductById(id, product);
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable int id) throws IdNotFoundException
	{
		return productService.deleteProductById(id);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public String myException(IdNotFoundException exception)
	{
		return exception.getMsg();
	}
    @ExceptionHandler(InValidPriceException.class)
    ResponseEntity<String> myPriceException(InValidPriceException exception)
    {
        return new ResponseEntity<String>(exception.getMsg(), HttpStatus.BAD_REQUEST);
    }
	
}
