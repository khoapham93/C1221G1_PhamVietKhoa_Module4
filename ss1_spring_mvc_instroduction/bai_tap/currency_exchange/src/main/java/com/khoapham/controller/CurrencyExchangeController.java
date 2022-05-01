package com.khoapham.controller;

import com.khoapham.service.ICurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyExchangeController {

    @Autowired
    private ICurrencyExchangeService iCurrencyExchangeService;

    @GetMapping(value = "/goExchange")
    public String goExchange() {
        return "exchange";
    }

    @GetMapping(value = "/exchange")
    public String exchange(@RequestParam Double usd, Model model) {
        //Double usdExchange = Double.valueOf(usd);
        Double vnd = iCurrencyExchangeService.calculate(usd);
        model.addAttribute("vnd", vnd);
        return "exchange";
    }
}
