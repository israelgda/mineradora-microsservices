package org.israelgda.message

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import org.israelgda.dtos.QuotationDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
class KafkaEvents {

    companion object {

        private val log: Logger = LoggerFactory.getLogger(KafkaEvents::class.java)

        @Channel("quotation-channel")
        lateinit var quotationRequestEmitter: Emitter<QuotationDTO>

        fun sendNewKafkaEvent(quotation: QuotationDTO) {
            log.info("-- Enviando Cotação para tópico Kafka --")
            quotationRequestEmitter.send(quotation).toCompletableFuture().join()
        }
    }

}