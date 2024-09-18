package com.ghackk.beststore.controller;

import com.ghackk.beststore.models.Product;
import com.ghackk.beststore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/dashboard")
    public String viewDashboard(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "dashboard";
    }

    @GetMapping("/create-job-sheet")
    public String createJobSheetForm(Model model) {
        model.addAttribute("product", new Product());
        return "createJobSheet";
    }

    @PostMapping("/save-job-sheet")
    public String saveJobSheet(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/dashboard";
    }

    @GetMapping("/view-job-sheet/{id}")
    public String viewJobSheet(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "viewJobSheet";
    }

    @GetMapping("/delete-job-sheet/{id}")
    public String deleteJobSheet(@PathVariable("id") int id) {
        productService.deleteProductById(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/search")
    public String searchJobSheets(@RequestParam("keyword") String keyword, Model model) {
        List<Product> result = productService.searchProducts(keyword);
        model.addAttribute("products", result);
        return "dashboard";
    }
    
    @GetMapping("/edit-job-sheet/{id}")
    public String editJobSheetForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "editJobSheet";
    }

    @PostMapping("/update-job-sheet/{id}")
    public String updateJobSheet(@PathVariable("id") int id, @ModelAttribute("product") Product updatedProduct) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct != null) {
            existingProduct.setReceivedDate(updatedProduct.getReceivedDate());
            existingProduct.setInventoryReceived(updatedProduct.getInventoryReceived());
            existingProduct.setReportedIssues(updatedProduct.getReportedIssues());
            existingProduct.setClientNotes(updatedProduct.getClientNotes());
            existingProduct.setAssignedTechnician(updatedProduct.getAssignedTechnician());
            existingProduct.setEstimatedAmount(updatedProduct.getEstimatedAmount());
            existingProduct.setDeadline(updatedProduct.getDeadline());
            existingProduct.setStatus(updatedProduct.getStatus());
            productService.saveProduct(existingProduct);
        }
        return "redirect:/view-job-sheet/" + id;
    }
    

}
