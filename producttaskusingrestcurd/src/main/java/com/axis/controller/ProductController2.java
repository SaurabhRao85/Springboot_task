
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
	@RequestMapping("/api/v2")
	public class ProductController2 {

	    @Autowired
	    ProductService productService;
	    
	    @PostMapping("/product")
	    ResponseEntity<Product> addEmployee(@RequestBody Product product) throws InValidPriceException
	    {
	        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
	    }
	    
	    @GetMapping("/product")
	    ResponseEntity<List<Product>> getAllProduct()
	    {
	        return new ResponseEntity<List<Product>>(productService.getAllProducts() , HttpStatus.OK);
	    }
	    
	    @GetMapping("/product/{id}")
	    ResponseEntity<Product> getProductById(@PathVariable  int id) throws IdNotFoundException
	    {
	        return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	    }
	    
	    @PutMapping("/product/{id}")
	    ResponseEntity<Product> updateProductById(@PathVariable int id,@RequestBody Product product) throws IdNotFoundException
	    {
	        return new ResponseEntity<Product>(productService.updateProductById(id, product), HttpStatus.OK);
	    }
	    
	    @DeleteMapping("/product/{id}")
	    ResponseEntity<String> deleteEmployeeById(@PathVariable int id) throws IdNotFoundException
	    {
	        return new ResponseEntity<String>(productService.deleteProductById(id), HttpStatus.OK);
	    }
	    
	    
	    @ExceptionHandler(IdNotFoundException.class)
	    ResponseEntity<String> myException(IdNotFoundException exception)
	    {
	        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	    }
	    @ExceptionHandler(InValidPriceException.class)
	    ResponseEntity<String> mySalaryException(InValidPriceException exception)
	    {
	        return new ResponseEntity<String>(exception.getMsg(), HttpStatus.BAD_REQUEST);
	    }
	    
	   
	}    
	 

