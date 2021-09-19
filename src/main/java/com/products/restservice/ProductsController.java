package com.products.restservice;


import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ProductsController {
	
	//Controller for GET, POST and SEARCH
    @Autowired
    private ProductsMethod product_service;
    

    @GetMapping("/products")
    private List<Products> getAllProducts()   
    {  
    return product_service.getAllProducts();  
    }  
    
    @PostMapping("/products")
    @GetMapping("/products")
    public Products add(@RequestBody Products product) {
    	Products obj = product_service.save(product);
        return product_service.findID(obj.getId());
    }
    
    @GetMapping("/products/{category}")
    private List<Products> getProductsbyCategory(@RequestBody Products product, @PathVariable  String category)   
    {  
    List<Products> prod = product_service.getAllProducts(); 
    List<Products> prodbycategory = new ArrayList<>();
    for (Products p: prod) {
    	if (category.equals(p.getCategory())) prodbycategory.add(p);
    }
    prodbycategory.sort((a,b)->a.getCreated_at().compareTo(b.getCreated_at()));
    	return prodbycategory;
    }  

   
   
}
