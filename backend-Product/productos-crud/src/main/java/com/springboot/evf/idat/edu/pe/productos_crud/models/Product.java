package com.springboot.evf.idat.edu.pe.productos_crud.models;

import com.springboot.evf.idat.edu.pe.productos_crud.validation.IsExistsDb;
import com.springboot.evf.idat.edu.pe.productos_crud.validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")


public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired
    @IsExistsDb
    private String sku;

    @IsRequired(message = "{IsRequired.product.name}")    
    @Size(min=3, max=30)
    private String name;

    @Min(value = 1, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

    @IsRequired //valida que no sea un caracter en blanco como los espacios
    private String description;
}
