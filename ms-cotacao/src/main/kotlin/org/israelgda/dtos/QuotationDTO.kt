package org.israelgda.dtos

import java.math.BigDecimal

class QuotationDTO (
    date: String,
    currencyPrice: BigDecimal
){

    constructor(): this("", BigDecimal(0.0))

    val date = date
    val currencyPrice = currencyPrice


    data class Builder(
        var date: String? = null,
        var currencyPrice: BigDecimal? = null
    ) {
        fun date(date: String) = apply { this.date = date }
        fun currencyPrice(currencyPrice: BigDecimal) = apply { this.currencyPrice = currencyPrice }

        fun build() = QuotationDTO(date?: "", currencyPrice?: BigDecimal(0.0))
    }
}