package com.ghackk.beststore.services.impl;

import com.ghackk.beststore.models.Product;
import com.ghackk.beststore.repository.ProductRepo;
import com.ghackk.beststore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepo.findByClientNameContaining(keyword);
    }
}
