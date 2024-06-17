package com.luiz.RecargaAlgar.Exception;

// Exceções personalizadas
public class InvalidRechargeAmountException extends Exception {
    public InvalidRechargeAmountException(String message) {
        super(message);
    }
}
