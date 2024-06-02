package com.EcomProductService.client;

import com.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.base.url}")
    private String fakeStoreBaseURL;

    @Value("${fakestore.api.product.path}")
    private String fakeStoreProductURL;


    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String productUrl = fakeStoreBaseURL.concat(fakeStoreProductURL);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList=  restTemplate.getForEntity(productUrl,FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        String productUrl = fakeStoreBaseURL.concat(fakeStoreProductURL).concat("/"+id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseList=  restTemplate.getForEntity(productUrl,FakeStoreProductResponseDTO.class);
        return productResponseList.getBody();
    }
}
