package com.springboot.evf.idat.edu.pe.productos_crud.repositories;

import org.springframework.data.repository.CrudRepository;


import com.springboot.evf.idat.edu.pe.productos_crud.models.Product;



public interface ProductRepository extends CrudRepository<Product, Long>{
    boolean existsBySku(String sku);
}
