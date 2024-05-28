package org.israelgda.dtos

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.NoArgsConstructor
import lombok.extern.jackson.Jacksonized

@Jacksonized
@Builder
@AllArgsConstructor
@NoArgsConstructor
class USDBRL (
    code: String,
    codeIn: String,
    name: String,
    high: String,
    low: String,
    varBid: String,
    pctChange: String,
    bid: String,
    ask: String,
    timestamp: String,
    create_date: String
){

    constructor(): this("", "","","","","","","","","","",)

    val code = code
    val codeIn = codeIn
    val name = name
    val high = high
    val low = low
    val varBid = varBid
    val pctChange = pctChange
    val bid = bid
    val ask = ask
    val timestamp = timestamp
    val create_date = create_date
}