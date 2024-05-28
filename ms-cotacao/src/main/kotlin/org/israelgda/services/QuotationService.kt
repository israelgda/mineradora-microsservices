package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.israelgda.client.CurrencyPriceClient
import org.israelgda.dtos.CurrencyPriceDTO
import org.israelgda.dtos.QuotationDTO
import org.israelgda.entities.Quotation
import org.israelgda.message.KafkaEvents
import org.israelgda.repositories.QuotationRepository
import java.math.BigDecimal
import java.time.Instant

@ApplicationScoped
class QuotationService {

    @Inject
    lateinit var quotationRepository: QuotationRepository

    @Inject
    @RestClient
    lateinit var currencyPriceClient: CurrencyPriceClient

    @Inject
    lateinit var kafkaEvents: KafkaEvents

    fun getCurrencyPrice() {
        val currencyPriceInfo = currencyPriceClient.getPriceByFair("USD-BRL")

        if(updateCurrentInfoPrice(currencyPriceInfo))
            kafkaEvents.sendNewKafkaEvent(
                QuotationDTO
                    .Builder()
                    .date(Instant.now().toString())
                    .currencyPrice(BigDecimal(currencyPriceInfo.USDBRL.bid))
                    .build())
    }

    private fun updateCurrentInfoPrice(currency: CurrencyPriceDTO): Boolean {
        val currentPrice = currency.USDBRL.bid.toBigDecimal()

        val quotationList = quotationRepository.findAll().list()

        if(quotationList.isEmpty()){
            saveQuotation(currency)
            return true
        } else {
            val lastDollarPrice = quotationList.last()

            if(currentPrice.toFloat() != lastDollarPrice.currencyPrice.toFloat()) {
                saveQuotation(currency)
                return true
            }
        }

        return false
    }

    private fun saveQuotation(currency: CurrencyPriceDTO) {

        quotationRepository.persist(
            Quotation(
                Instant.now(),
                BigDecimal(currency.USDBRL.bid),
                currency.USDBRL.pctChange,
                "USD-BRL"
            )
        )
    }
}