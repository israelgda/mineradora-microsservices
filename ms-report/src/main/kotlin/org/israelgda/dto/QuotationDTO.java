package org.israelgda.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class QuotationDTO {

    public Instant date;
    public BigDecimal currencyPrice;

    public QuotationDTO(Instant date, BigDecimal currencyPrice) {
        this.date = date;
        this.currencyPrice = currencyPrice;
    }
}
