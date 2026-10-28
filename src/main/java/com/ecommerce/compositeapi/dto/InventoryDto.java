package com.ecommerce.compositeapi.dto;

public class InventoryDto {

    private String productId;
    private String stockStatus;
    private Integer availableUnits;
    private String warehouseLocation;
    private String estimatedDelivery;

    public InventoryDto() {
    }

    public InventoryDto(String productId, String stockStatus, Integer availableUnits, 
                        String warehouseLocation, String estimatedDelivery) {
        this.productId = productId;
        this.stockStatus = stockStatus;
        this.availableUnits = availableUnits;
        this.warehouseLocation = warehouseLocation;
        this.estimatedDelivery = estimatedDelivery;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Integer getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(String estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
}