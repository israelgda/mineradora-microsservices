package org.israelgda.client

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.israelgda.dtos.ProposalDetailsDTO

@Path("/api/proposal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter::class)
interface ProposalRestClient {


    @GET
    @Path("/{id}")
    fun getProposalDetailsById(@PathParam("id") id: Long): ProposalDetailsDTO

    @POST
    fun createProposal(proposalDetailsDTO: ProposalDetailsDTO): Response

    @DELETE
    @Path("/{id}")
    fun deleteProposal(@PathParam("id") id: Long): Response
}

