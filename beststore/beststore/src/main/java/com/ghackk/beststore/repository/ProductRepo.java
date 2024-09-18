package com.ghackk.beststore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ghackk.beststore.models.Product;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findByClientNameContaining(String keyword);
    
}
