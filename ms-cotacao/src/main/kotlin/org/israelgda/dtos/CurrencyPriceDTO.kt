package org.israelgda.dtos

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.extern.jackson.Jacksonized

@Jacksonized
@Builder
@AllArgsConstructor
class CurrencyPriceDTO (
    usdBrl: USDBRL
){

    val usdBrl = usdBrl
}