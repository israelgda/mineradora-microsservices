package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.israelgda.repositories.QuotationRepository

@ApplicationScoped
class QuotationService {

    @Inject
    lateinit var quotationRepository: QuotationRepository
}