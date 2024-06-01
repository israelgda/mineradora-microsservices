package org.israelgda.utils

import org.israelgda.dto.ProposalDTO
import org.israelgda.dto.ProposalDetailsDTO
import org.israelgda.entities.Proposal

fun Proposal.toDetailsDTO() = ProposalDetailsDTO(
    this.id,
    this.customer,
    this.priceTonne,
    0,
    this.country,
    this.propostalValidityDays
)

fun ProposalDetailsDTO.toEntity(): Proposal = Proposal(
    this.customer,
    this.priceTonne,
    this.country,
    this.proposalValidityDays
)

fun Proposal.toSimplifiedDTO(): ProposalDTO = ProposalDTO(
    this.id,
    this.customer,
    this.priceTonne
)

