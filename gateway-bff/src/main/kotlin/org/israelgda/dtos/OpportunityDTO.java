package org.israelgda.dtos;

import java.math.BigDecimal;

public class OpportunityDTO {

    public Long proposalId;
    public String customer;
    public BigDecimal priceTonne;

    public Integer lastDollarQuotation;

    public OpportunityDTO(Long proposalId, String customer, BigDecimal priceTonne, Integer lastDollarQuotation) {
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.lastDollarQuotation = lastDollarQuotation;
    }
}
