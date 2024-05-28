package org.israelgda.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "quotation")
class Quotation(
    date: Instant,
    currencyPrice: BigDecimal,
    pctChange: String,
    pair: String
) {
    constructor(): this(Instant.now(), BigDecimal(0.0), "", "")

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column(name = "quotation_date")
    var date = date

    @Column(name = "currency_price")
    var currencyPrice = currencyPrice

    @Column(name = "pct_change")
    var pctChange = pctChange

    var pair = pair
}