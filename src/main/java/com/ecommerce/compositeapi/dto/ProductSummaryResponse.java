package com.ecommerce.compositeapi.dto;

public class ProductSummaryResponse {

    private String product_id;
    private String title;
    private Double price_usd;
    private Double price_mxn;
    private String stock_status;
    private Integer available_units;
    private String currency_conversion_source;
    private String status;

    public ProductSummaryResponse() {
    }

    public ProductSummaryResponse(String product_id, String title, Double price_usd, Double price_mxn,
                                  String stock_status, Integer available_units, 
                                  String currency_conversion_source, String status) {
        this.product_id = product_id;
        this.title = title;
        this.price_usd = price_usd;
        this.price_mxn = price_mxn;
        this.stock_status = stock_status;
        this.available_units = available_units;
        this.currency_conversion_source = currency_conversion_source;
        this.status = status;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(Double price_usd) {
        this.price_usd = price_usd;
    }

    public Double getPrice_mxn() {
        return price_mxn;
    }

    public void setPrice_mxn(Double price_mxn) {
        this.price_mxn = price_mxn;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    public Integer getAvailable_units() {
        return available_units;
    }

    public void setAvailable_units(Integer available_units) {
        this.available_units = available_units;
    }

    public String getCurrency_conversion_source() {
        return currency_conversion_source;
    }

    public void setCurrency_conversion_source(String currency_conversion_source) {
        this.currency_conversion_source = currency_conversion_source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}