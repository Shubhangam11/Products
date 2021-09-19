package com.products.restservice;
import java.util.*;


import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.jpa.domain.Specification;

@Service
@Transactional
public class ProductsMethod {
	
	 @Autowired
	 private ProductRepository repository;
	 
	    public List<Products> listAll() {
	        return repository.findAll();
	    }
	    
	    public ProductRepository getRepository() {
	    	return this.repository;
	    }
	    public List<Products> getAllProducts()   
	    {  
	    List<Products> ProductsList = new ArrayList<Products>();  
	    repository.findAll().forEach(Products -> ProductsList.add(Products));  
	    return ProductsList;  
	    }  
	    public Products findID(String id) {
	        return repository.findById(id).get();
	    }
	   
	
	    public Products save(Products product) {
	        return repository.save(product);
	    }

}
