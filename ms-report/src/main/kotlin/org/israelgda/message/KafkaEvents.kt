package org.israelgda.message

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.israelgda.dto.ProposalDTO
import org.israelgda.dto.QuotationDTO
import org.israelgda.services.OpportunityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
class KafkaEvents {

    private val log: Logger = LoggerFactory.getLogger(KafkaEvents::class.java)


    @Inject
    lateinit var opportunityService: OpportunityService

    @Incoming("proposal")
    @Transactional
    fun receiveProposal(proposalDTO: ProposalDTO) {
        log.info("-- Recebendo Nova Proposta do Tópico 'proposal' no Kafka --")
        opportunityService.buildOpportunity(proposalDTO)
    }

    @Incoming("quotation")
    @Transactional
    fun receiveQuotation(quotationDTO: QuotationDTO) {
        log.info("-- Recebendo Nova Cotação do Tópico 'quotation' no Kafka --")
        opportunityService.saveQuotation(quotationDTO)
    }

}