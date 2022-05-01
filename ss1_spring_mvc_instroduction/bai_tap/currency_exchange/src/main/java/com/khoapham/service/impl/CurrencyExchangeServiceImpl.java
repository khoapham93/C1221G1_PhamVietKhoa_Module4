package com.khoapham.service.impl;

import com.khoapham.service.ICurrencyExchangeService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements ICurrencyExchangeService {
    @Override
    public Double calculate(double usd) {
        return usd*23000;
    }
}
