package org.israelgda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProposalDetailsDTO {

    public Long proposalId;
    public String customer;
    public BigDecimal priceTonne;
    public Integer tonnes;
    public String country;
    public Integer proposalValidityDays;
}
