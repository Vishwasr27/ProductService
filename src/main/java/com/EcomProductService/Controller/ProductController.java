package com.EcomProductService.Controller;

import com.EcomProductService.Service.ProductService;
import com.EcomProductService.dto.FakeStoreProductRatingDTO;
import com.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.EcomProductService.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<List<FakeStoreProductResponseDTO>> getProducts(){
       List<FakeStoreProductResponseDTO> products =  productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FakeStoreProductResponseDTO> getProduct(@PathVariable("id") int id){
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
