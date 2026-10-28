package com.ecommerce.compositeapi.controller;

import com.ecommerce.compositeapi.dto.InventoryDto;
import com.ecommerce.compositeapi.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservices")
public class InternalMicroservicesController {

    // Microservicio 1: Catálogo de Productos
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable String id) {
        ProductDto product = new ProductDto(
            id,
            "Laptop Gamer XYZ",
            "Laptop de alto rendimiento para gaming y desarrollo",
            "Electrónica",
            1200.00
        );
        return ResponseEntity.ok(product);
    }

    // Microservicio 2: Inventario y Almacén
    @GetMapping("/inventory/{productId}")
    public ResponseEntity<InventoryDto> getInventoryByProductId(@PathVariable String productId) {
        InventoryDto inventory = new InventoryDto(
            productId,
            "IN_STOCK",
            15,
            "Almacén Central - Pasillo 4",
            "2-3 días hábiles"
        );
        return ResponseEntity.ok(inventory);
    }
}