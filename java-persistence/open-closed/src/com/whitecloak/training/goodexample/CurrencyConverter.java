package com.whitecloak.training.goodexample;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Map;

public class CurrencyConverter {

    private final Map<Currency, BigDecimal> exchangeRate;

    public CurrencyConverter(Map<Currency, BigDecimal> exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public BigDecimal converyFromPhp(BigDecimal phpAmount, Currency currency) {
        BigDecimal quote = exchangeRate.get(currency);

        if (quote != null) {
            return phpAmount.divide(quote, RoundingMode.HALF_EVEN);
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
    }
}
