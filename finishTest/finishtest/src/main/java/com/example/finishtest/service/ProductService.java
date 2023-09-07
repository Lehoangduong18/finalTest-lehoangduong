package com.example.finishtest.service;

import com.example.finishtest.entity.Product;
import com.example.finishtest.model.ProductStatus;
import com.example.finishtest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProductService {
    final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public Product insert(Product product){
        product.setCreateDate(LocalDateTime.now());
        return productRepository.save(product);
    }
    public Product update(Product product){
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()){

            return productRepository.save(product);
        }
        return null;
    }

    public Product delete(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product foundProduct= optionalProduct.get();
            if (foundProduct.getStatus() == ProductStatus.PRODUCT_PENDING){
                foundProduct.setStatus(ProductStatus.PRODUCT_CANCEL);
            }
            return productRepository.save(foundProduct);
        }
        return null;
    }


    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public List<Product> findAllProductActive(){
        return productRepository.findAll().stream().filter(product -> product.isActive()==true).collect(Collectors.toList());

    }
    public List<Product> findAllProductFinish(){
        return productRepository.findAll().stream().filter(product -> product.isFinish()==true).collect(Collectors.toList());

    }
}

