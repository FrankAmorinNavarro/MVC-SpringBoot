package com.springboot.evf.idat.edu.pe.productos_crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.evf.idat.edu.pe.productos_crud.models.Product;
import com.springboot.evf.idat.edu.pe.productos_crud.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    //VISTA
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {

        Optional<Product> producOptional = service.findById(id);

        if(producOptional.isPresent()) {
            return ResponseEntity.ok(producOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //CREAR
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) { 
               

        if (result.hasFieldErrors()){
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }


    //ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Product product, BindingResult result, @PathVariable Long id) {
        

        if (result.hasFieldErrors()){
            return validation(result);
        }

        Optional<Product> productOptional = service.update(id, product);
        if(productOptional.isPresent()) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
       

        Optional<Product> producOptional = service.delete(id);

        if(producOptional.isPresent()) {
            return ResponseEntity.ok(producOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity <Map<String, String>> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo" + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }
    
}
