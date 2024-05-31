package org.israelgda.utils

import org.israelgda.dto.ProposalDTO
import org.israelgda.dto.ProposalDetailsDTO
import org.israelgda.entities.Proposal

fun Proposal.toDetailsDTO(): ProposalDetailsDTO = ProposalDetailsDTO.builder()
    .proposalId(this.id)
    .customer(this.customer)
    .priceTonne(this.priceTonne)
    .tonnes(0)
    .country(this.country)
    .proposalValidityDays(this.propostalValidityDays)
    .build()

fun ProposalDetailsDTO.toEntity(): Proposal = Proposal(
    this.customer,
    this.priceTonne,
    this.country,
    this.proposalValidityDays
)

fun Proposal.toSimplifiedDTO(): ProposalDTO = ProposalDTO.builder()
    .proposalId(this.id)
    .customer(this.customer)
    .priceTonne(this.priceTonne)
    .build()

