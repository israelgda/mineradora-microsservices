package org.israelgda.scheduler

import io.quarkus.scheduler.Scheduled
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.israelgda.message.KafkaEvents
import org.israelgda.services.QuotationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
class QuotationScheduler {

    private val log: Logger = LoggerFactory.getLogger(KafkaEvents::class.java)


    @Inject
    lateinit var quotationService: QuotationService

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    fun schedule() {
        log.info("-- Executando scheduler --")
        quotationService.getCurrencyPrice()
    }
}