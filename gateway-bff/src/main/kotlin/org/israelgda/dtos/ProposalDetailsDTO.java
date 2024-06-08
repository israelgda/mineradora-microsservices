package org.israelgda.dtos;

import java.math.BigDecimal;

public class ProposalDetailsDTO {

    public Long proposalId;
    public String customer;
    public BigDecimal priceTonne;
    public Integer tonnes;
    public String country;
    public Integer proposalValidityDays;

    public ProposalDetailsDTO(Long proposalId, String customer, BigDecimal priceTonne, Integer tonnes, String country, Integer proposalValidityDays) {
        this.proposalId = proposalId;
        this.customer = customer;
        this.priceTonne = priceTonne;
        this.tonnes = tonnes;
        this.country = country;
        this.proposalValidityDays = proposalValidityDays;
    }
}
