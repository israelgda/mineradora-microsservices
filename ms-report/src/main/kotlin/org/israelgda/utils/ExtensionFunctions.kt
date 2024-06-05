package org.israelgda.utils

import org.israelgda.dto.OpportunityDTO
import org.israelgda.dto.QuotationDTO
import org.israelgda.entities.Opportunity
import org.israelgda.entities.Quotation

fun Opportunity.toDTO() = OpportunityDTO(
    this.proposalId,
    this.customer,
    this.priceTonne,
    this.lastDollarQuotation
)

fun QuotationDTO.toEntity() = Quotation(
    this.date,
    this.currencyPrice
)