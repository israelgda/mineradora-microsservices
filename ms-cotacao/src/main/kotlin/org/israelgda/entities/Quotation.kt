package org.israelgda.entities

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "quotation")
class Quotation(
    date: String,
    currencyPrice: BigDecimal,
    pctChange: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var date = date

    @Column(name = "currency_price")
    var currencyPrice = date

    @Column(name = "pct_change")
    var pctChange = pctChange
}