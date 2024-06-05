package org.israelgda.entities

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "quotation")
class Quotation (
    date: Instant,
    currentPrice: BigDecimal
){

    constructor(): this(Instant.now(), BigDecimal(0))

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0L

    @Column(name = "quotation_date")
    var date = date

    @Column(name = "current_price")
    var currentPrice = currentPrice
}