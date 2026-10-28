package com.ecommerce.compositeapi.service;

import com.ecommerce.compositeapi.dto.InventoryDto;
import com.ecommerce.compositeapi.dto.ProductDto;
import com.ecommerce.compositeapi.dto.ProductSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class CompositeApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyService currencyService;

    public ProductSummaryResponse getProductSummary(String productId) {
        // Petición asíncrona al Microservicio 1: Catálogo
        CompletableFuture<ProductDto> productFuture = CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/microservices/products/" + productId;
                return restTemplate.getForObject(url, ProductDto.class);
            } catch (Exception e) {
                return null;
            }
        });

        // Petición asíncrona al Microservicio 2: Inventario
        CompletableFuture<InventoryDto> inventoryFuture = CompletableFuture.supplyAsync(() -> {
            try {
                String url = "http://localhost:8080/microservices/inventory/" + productId;
                return restTemplate.getForObject(url, InventoryDto.class);
            } catch (Exception e) {
                return null;
            }
        });

        // Petición asíncrona al Microservicio 3: API Externa de Divisas
        CompletableFuture<Double> rateFuture = CompletableFuture.supplyAsync(() -> 
            currencyService.getUsdToMxnRate()
        );

        // Esperar la resolución de todas las promesas/futuros
        CompletableFuture.allOf(productFuture, inventoryFuture, rateFuture).join();

        ProductDto product = productFuture.join();
        InventoryDto inventory = inventoryFuture.join();
        Double exchangeRate = rateFuture.join();

        // Mapeo y transformación hacia el contrato final consolidado
        ProductSummaryResponse response = new ProductSummaryResponse();
        
        if (product != null) {
            response.setProduct_id(product.getId());
            response.setTitle(product.getName());
            response.setPrice_usd(product.getPriceUsd());
            
            if (exchangeRate != null) {
                response.setPrice_mxn(product.getPriceUsd() * exchangeRate);
            }
        } else {
            response.setProduct_id(productId);
            response.setTitle("Producto no disponible");
            response.setPrice_usd(0.0);
            response.setPrice_mxn(0.0);
        }

        if (inventory != null) {
            response.setStock_status(inventory.getStockStatus());
            response.setAvailable_units(inventory.getAvailableUnits());
        } else {
            response.setStock_status("UNKNOWN");
            response.setAvailable_units(0);
        }

        response.setCurrency_conversion_source("Frankfurter External API");
        response.setStatus("SUCCESS");

        return response;
    }
}