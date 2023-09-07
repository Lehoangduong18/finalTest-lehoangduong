package com.example.finishtest.controller;

import com.example.finishtest.entity.Product;
import com.example.finishtest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")

public class ProductController {

    final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/findAllProductAcitve")
    public ResponseEntity<?> findAllProductActive(){
        return ResponseEntity.ok(productService.findAllProductActive());
    }
    @GetMapping("/findAllProductFinish")
    public ResponseEntity<?> findAllProductFinish(){
        return ResponseEntity.ok(productService.findAllProductFinish());
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Product product){
        return ResponseEntity.ok(productService.insert(product));
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product){
        return ResponseEntity.ok(productService.update(product));
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ResponseEntity.ok(productService.delete(id));
    }
}
