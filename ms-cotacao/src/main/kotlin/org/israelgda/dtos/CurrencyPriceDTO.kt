package org.israelgda.dtos

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import lombok.extern.jackson.Jacksonized

@Jacksonized
@Builder
@AllArgsConstructor
@NoArgsConstructor
class CurrencyPriceDTO (
    USDBRL: USDBRL
){

    constructor(): this(USDBRL())

    val USDBRL = USDBRL
}