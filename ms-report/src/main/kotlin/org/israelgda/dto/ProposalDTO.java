package org.israelgda.dto;

import java.math.BigDecimal;

public class ProposalDTO {

    public Long proposalId;
    public String customer;
    public BigDecimal priceTonne;

    public ProposalDTO(Long proposalId, String customer, BigDecimal priceTonne) {
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
    }
}
