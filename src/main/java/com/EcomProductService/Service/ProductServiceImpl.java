package com.EcomProductService.Service;

import com.EcomProductService.client.FakeStoreClient;
import com.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.EcomProductService.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        return fakeStoreClient.getAllProducts();
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) {
        return fakeStoreClient.getProductById(productId);
    }
}
