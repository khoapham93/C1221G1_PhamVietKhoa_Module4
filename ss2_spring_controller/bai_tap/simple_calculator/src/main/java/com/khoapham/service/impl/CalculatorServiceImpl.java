package com.khoapham.service.impl;

import com.khoapham.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public Double calculator(Double number1, Double number2, String operator) {
        switch (operator) {
            case "Addition(+)":
                return number1 + number2;
            case "Subtraction(-)":
                return number1 - number2;
            case "Multiplication(x)":
                return number1 * number2;
            case "Division(/)":
                if (number2 == 0) {
                    throw new ArithmeticException("Can't division by 0!");
                } else {
                    return number1 + number2;
                }
            default:
                return null;

        }
    }
}
