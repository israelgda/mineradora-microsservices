package org.israelgda.client

import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.israelgda.dtos.CurrencyPriceDTO

@Path("/last")
@RegisterRestClient(baseUri="https://economia.awesomeapi.com.br")
@ApplicationScoped
interface CurrencyPriceClient {

    @GET
    @Path("/{pair}")
    fun getPriceByFair(@PathParam("pair") pair: String): CurrencyPriceDTO
}