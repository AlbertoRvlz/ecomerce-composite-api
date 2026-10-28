package com.ecommerce.compositeapi.controller;

import com.ecommerce.compositeapi.dto.ProductSummaryResponse;
import com.ecommerce.compositeapi.service.CompositeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CompositeApiController {

    @Autowired
    private CompositeApiService compositeApiService;

    @GetMapping("/product-summary/{id}")
    public ResponseEntity<ProductSummaryResponse> getProductSummary(@PathVariable String id) {
        ProductSummaryResponse summary = compositeApiService.getProductSummary(id);
        return ResponseEntity.ok(summary);
    }
}