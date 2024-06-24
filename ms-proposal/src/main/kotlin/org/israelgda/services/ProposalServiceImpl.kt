package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.israelgda.dto.ProposalDetailsDTO
import org.israelgda.message.KafkaEvents
import org.israelgda.repositories.ProposalRepository
import org.israelgda.services.exceptions.ResourceNotFoundException
import org.israelgda.utils.toDetailsDTO
import org.israelgda.utils.toEntity
import org.israelgda.utils.toSimplifiedDTO

private const val PROPOSAL_NOT_FOUND_MSG_ERROR = "Proposal not found for id:"

@ApplicationScoped
class ProposalServiceImpl: ProposalService {

    @Inject
    lateinit var proposalRepository: ProposalRepository

    @Inject
    lateinit var kafkaMessages: KafkaEvents

    override fun findFullProposalDetails(id: Long): ProposalDetailsDTO {
        return proposalRepository.findById(id)
            ?.toDetailsDTO()
            ?: throw ResourceNotFoundException("$PROPOSAL_NOT_FOUND_MSG_ERROR $id")
    }

    @Transactional
    override fun create(proposalDetailsDTO: ProposalDetailsDTO) {
        val proposalEntity = proposalDetailsDTO.toEntity()

        try {
            proposalRepository.persist(proposalEntity)
        } catch (ex: RuntimeException){
            throw RuntimeException(ex.message)
        }

        kafkaMessages.sendNewKafkaEvent(proposalEntity.toSimplifiedDTO())
    }

    @Transactional
    override fun delete(id: Long) {
        proposalRepository.findById(id)
            ?.let {
                proposalRepository.deleteById(id)
            }?: throw ResourceNotFoundException("$PROPOSAL_NOT_FOUND_MSG_ERROR $id")
    }

}