package com.ghackk.beststore.services;

import com.ghackk.beststore.models.Product;
import java.util.List;

public interface ProductService {
	
    List<Product> getAllProducts();
    
    Product getProductById(int id);
    
    void saveProduct(Product product);
    
    void deleteProductById(int id);
    
    List<Product> searchProducts(String keyword);
}
