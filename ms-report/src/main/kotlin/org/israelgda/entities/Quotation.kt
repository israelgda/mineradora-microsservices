package org.israelgda.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "quotation")
class Quotation (
    id: Long,
    date: Instant,
    currencyPrice: BigDecimal
){

    constructor(): this(0L, Instant.now(), BigDecimal(0))

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0L

    @Column(name = "quotation_date")
    var date = date

    @Column(name = "currency_price")
    var currencyPrice = currencyPrice
}