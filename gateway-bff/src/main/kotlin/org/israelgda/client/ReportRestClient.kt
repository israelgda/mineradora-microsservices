package org.israelgda.client

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.israelgda.dtos.OpportunityDTO

@Path("/api/opportunity")
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter::class)
interface ReportRestClient {

    @GET
    @Path("/report")
    fun requestOpportunitiesData(): List<OpportunityDTO>
}