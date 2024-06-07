package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import org.israelgda.dto.OpportunityDTO
import org.israelgda.dto.ProposalDTO
import org.israelgda.dto.QuotationDTO

@ApplicationScoped
interface OpportunityService {

    fun buildOpportunity(proposalDTO: ProposalDTO)
    fun saveQuotation(quotationDTO: QuotationDTO)
    fun generateOpportunityData(): List<OpportunityDTO>
}