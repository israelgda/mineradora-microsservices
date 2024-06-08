package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.israelgda.client.ProposalRestClient
import org.israelgda.dtos.ProposalDetailsDTO

@ApplicationScoped
class ProposalServiceImpl: ProposalService {

    @Inject
    @RestClient
    lateinit var proposalRestClient: ProposalRestClient

    override fun findFullProposalDetails(id: Long): ProposalDetailsDTO {
        return proposalRestClient.getProposalDetailsById(id)
    }

    @Transactional
    override fun createProposal(proposalDetailsDTO: ProposalDetailsDTO): Response {
        return proposalRestClient.createProposal(proposalDetailsDTO)
    }


    @Transactional
    override fun deleteProposal(id: Long): Response {
        return proposalRestClient.deleteProposal(id)
    }
}