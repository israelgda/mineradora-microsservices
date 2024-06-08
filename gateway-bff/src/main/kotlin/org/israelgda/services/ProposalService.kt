package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.core.Response
import org.israelgda.dtos.ProposalDetailsDTO

@ApplicationScoped
interface ProposalService {

    fun findFullProposalDetails(@PathParam("id") id: Long): ProposalDetailsDTO
    fun createProposal(proposalDetailsDTO: ProposalDetailsDTO): Response
    fun deleteProposal(id: Long): Response
}