package org.israelgda.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "opportunity")
class Opportunity (
    date: Instant,
    proposalId: Long,
    customer: String,
    priceTonne: BigDecimal,
    lastDollarQuotation: BigDecimal
) {

    constructor(): this(Instant.now(), 0L, "", BigDecimal(0), BigDecimal(0))

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0L

    @Column(name = "opportunity_date")
    var date = date

    @Column(name = "proposal_id")
    var proposalId = proposalId

    var customer = customer

    var priceTonne = priceTonne

    var lastDollarQuotation = lastDollarQuotation

}