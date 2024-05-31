package org.israelgda.message

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import org.israelgda.dto.ProposalDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
class KafkaEvents {

    private val log: Logger = LoggerFactory.getLogger(KafkaEvents::class.java)


    @Channel("proposal")
    lateinit var proposalRequestEmitter: Emitter<ProposalDTO>

    fun sendNewKafkaEvent(proposalDTO: ProposalDTO) {
        log.info("-- Enviando nova proposta para tópico Kafka --")
        proposalRequestEmitter.send(proposalDTO).toCompletableFuture().join()
    }
}