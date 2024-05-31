package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import org.israelgda.dto.ProposalDTO
import org.israelgda.dto.ProposalDetailsDTO

@ApplicationScoped
interface ProposalService {

    fun findFullProposalDetails(id: Long): ProposalDetailsDTO
    fun create(proposalDetailsDTO: ProposalDetailsDTO)
    fun delete(id: Long)
}