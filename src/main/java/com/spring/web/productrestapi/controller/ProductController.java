package com.spring.web.productrestapi.controller;

import com.spring.web.productrestapi.model.Product;
import com.spring.web.productrestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){
        return  new ResponseEntity<Product>(productService.getProductById(productId),HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long productId,@RequestBody Product product){
        return new ResponseEntity<Product>(productService.updateProduct(product,productId),HttpStatus.OK);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable("productId") long id){
        productService.deleteProductById(id);
        return new ResponseEntity<String>("Product delete successfully",HttpStatus.OK);

    }

}
