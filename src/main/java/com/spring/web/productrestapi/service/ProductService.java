package com.spring.web.productrestapi.service;

import com.spring.web.productrestapi.model.Product;


import java.util.List;


public interface ProductService {
   Product saveProduct(Product product);

   List<Product> getAllProduct();
   Product getProductById(long productId);

   Product updateProduct(Product product,long productId);

   void deleteProductById(long id);
}
