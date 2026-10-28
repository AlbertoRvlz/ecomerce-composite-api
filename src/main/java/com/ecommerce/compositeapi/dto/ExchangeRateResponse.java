package com.ecommerce.compositeapi.dto;

import java.util.Map;

public class ExchangeRateResponse {

    private Double amount;
    private String base;
    private String date;
    private Map<String, Double> rates;

    public ExchangeRateResponse() {
    }

    public ExchangeRateResponse(Double amount, String base, String date, Map<String, Double> rates) {
        this.amount = amount;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}