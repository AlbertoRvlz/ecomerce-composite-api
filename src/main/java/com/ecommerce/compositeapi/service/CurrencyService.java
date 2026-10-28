package com.ecommerce.compositeapi.service;

import com.ecommerce.compositeapi.dto.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String FRANKFURTER_URL = "https://api.frankfurter.app/latest?from=USD&to=MXN";

    public Double getUsdToMxnRate() {
        try {
            ExchangeRateResponse response = restTemplate.getForObject(FRANKFURTER_URL, ExchangeRateResponse.class);
            if (response != null && response.getRates() != null && response.getRates().containsKey("MXN")) {
                return response.getRates().get("MXN");
            }
        } catch (Exception e) {
            // Valor por defecto en caso de fallo en la llamada a la API externa (Tolerancia a fallos)
            System.err.println("Error al consultar API de Frankfurter: " + e.getMessage());
        }
        return 17.0; // Tasa fallback en caso de error
    }
}