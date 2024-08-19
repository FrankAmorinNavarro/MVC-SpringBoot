package com.frank.abigail.evf.srpingboot.backend.products_backend;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.frank.abigail.evf.srpingboot.backend.products_backend.models.Product;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        config.exposeIdsFor(Product.class);

    }

    
}
