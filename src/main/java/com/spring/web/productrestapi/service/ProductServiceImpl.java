package com.spring.web.productrestapi.service;

import com.spring.web.productrestapi.model.Product;
import com.spring.web.productrestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
   private ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @Override
    public Product updateProduct(Product product,long productId) {
        Product productAvaiable=productRepository.findById(productId).orElseThrow();
        productAvaiable.setName(product.getName());
        productAvaiable.setDescription(product.getName());
        productAvaiable.setPrice(product.getPrice());

        return productAvaiable;

    }

    @Override
    public void deleteProductById(long id) {
         productRepository.findById(id).orElseThrow();
          productRepository.deleteById(id);
    }
}
