package org.israelgda.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.israelgda.entities.Proposal
import java.util.*

@ApplicationScoped
class ProposalRepository: PanacheRepository<Proposal> {

    fun findBycustomer(customer: String): Proposal? {
        return find("customer", customer).firstResult()
    }
}