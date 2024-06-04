package org.israelgda.utils

import org.israelgda.dto.OpportunityDTO
import org.israelgda.entities.Opportunity

fun Opportunity.toDTO() = OpportunityDTO(
    this.proposalId,
    this.customer,
    this.priceTonne,
    this.lastDollarQuotation
)

