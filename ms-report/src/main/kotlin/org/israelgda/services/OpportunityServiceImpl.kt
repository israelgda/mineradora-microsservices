package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.israelgda.dto.OpportunityDTO
import org.israelgda.dto.ProposalDTO
import org.israelgda.dto.QuotationDTO
import org.israelgda.entities.Opportunity
import org.israelgda.repositories.OpportunityRepository
import org.israelgda.repositories.QuotationRepository
import org.israelgda.utils.toDTO
import org.israelgda.utils.toEntity
import java.time.Instant

@ApplicationScoped
class OpportunityServiceImpl: OpportunityService {

    @Inject
    lateinit var opportunityRepository: OpportunityRepository

    @Inject
    lateinit var quotationRepository: QuotationRepository

    @Transactional
    override fun buildOpportunity(proposalDTO: ProposalDTO) {
        val quotations = quotationRepository.findAll().list().reversed()

        val opportunity = Opportunity()
        opportunity.date = Instant.now()
        opportunity.proposalId = proposalDTO.proposalId
        opportunity.customer = proposalDTO.customer
        opportunity.priceTonne = proposalDTO.priceTonne
        opportunity.lastDollarQuotation = quotations.first().currentPrice

        opportunityRepository.persist(opportunity)
    }

    @Transactional
    override fun saveQuotation(quotationDTO: QuotationDTO) {
        val quotation = quotationDTO.toEntity()
        quotationRepository.persist(quotation)
    }

    override fun generateOpportunityData(): List<OpportunityDTO> {
        return opportunityRepository
            .findAll()
            .list()
            .map { it.toDTO() }
    }

}