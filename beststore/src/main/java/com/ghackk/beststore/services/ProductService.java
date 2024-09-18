package com.ghackk.beststore.services;

import com.ghackk.beststore.models.Product;
import java.util.List;

public interface ProductService {
	// Get All Products
    List<Product> getAllProducts();
    //Get Prdouct By Id
    Product getProductById(int id);
    //Save Product
    void saveProduct(Product product);
    //Delete Product
    void deleteProductById(int id);
    //Search Product with name
    List<Product> searchProducts(String keyword);
}
