package org.israelgda.dtos

class USDBRL (
    code: String,
    codein: String,
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

    constructor(): this(
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""
    )

    val code = code
    val codein = codein
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