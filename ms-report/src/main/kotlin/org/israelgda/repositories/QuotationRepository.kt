package org.israelgda.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.israelgda.entities.Quotation

@ApplicationScoped
class QuotationRepository: PanacheRepository<Quotation> {
}