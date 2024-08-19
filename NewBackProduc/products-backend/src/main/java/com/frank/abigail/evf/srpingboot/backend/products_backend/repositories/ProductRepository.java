package com.frank.abigail.evf.srpingboot.backend.products_backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.frank.abigail.evf.srpingboot.backend.products_backend.models.Product;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "products")
public interface ProductRepository extends CrudRepository<Product, Long>{

}
