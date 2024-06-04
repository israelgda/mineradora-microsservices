package org.israelgda.dto;

import java.math.BigDecimal;

public class OpportunityDTO {

    public Long proposalId;
    public String customer;
    public BigDecimal priceTonne;
    public BigDecimal lastDollarQuotation;

    public OpportunityDTO(Long proposalId, String customer, BigDecimal priceTonne, BigDecimal lastDollarQuotation) {
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.lastDollarQuotation = lastDollarQuotation;
    }
}
