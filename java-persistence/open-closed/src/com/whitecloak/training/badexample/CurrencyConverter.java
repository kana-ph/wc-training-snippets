package com.whitecloak.training.badexample;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

public class CurrencyConverter {

    public BigDecimal converyFromPhp(BigDecimal phpAmount, Currency currency) {
        if (currency.equals(Currency.getInstance("USD"))) {
            return phpAmount.divide(new BigDecimal("51.12"), RoundingMode.HALF_EVEN);
        } else if (currency.equals(Currency.getInstance("EUR"))) {
            return phpAmount.divide(new BigDecimal("56.96"), RoundingMode.HALF_EVEN);
        } else if (currency.equals(Currency.getInstance("JPY"))) {
            return phpAmount.divide(new BigDecimal("0.47"), RoundingMode.HALF_EVEN);
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
    }
}
