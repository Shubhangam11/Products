package com.products.restservice;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Products, String>, JpaSpecificationExecutor<Products> {
	List<Products> findAllByCategory(String category, Pageable pageable);
   /* @Override
    public List<Products> findAll() {
        return studentDao.findAll(sortByIdAsc());
    }*/
}
