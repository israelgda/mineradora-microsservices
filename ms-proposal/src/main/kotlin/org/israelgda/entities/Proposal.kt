package org.israelgda.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "proposal")
class Proposal (
    customer: String,
    priceTonne: BigDecimal,
    country: String,
    propostalValidityDays: Int
){
    constructor(): this("", BigDecimal(0), "", 0)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0L

    var customer = customer

    @Column(name = "price_tonne")
    var priceTonne = priceTonne
    var country = country

    @Column(name = "propostal_validity_days")
    var propostalValidityDays = propostalValidityDays
    lateinit var created: Instant

    @PrePersist
    fun createdDate(){
        created = Instant.now()
    }
}