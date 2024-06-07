package org.israelgda.controllers

import io.quarkus.security.Authenticated
import jakarta.annotation.security.RolesAllowed
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.jwt.JsonWebToken
import org.israelgda.dto.ProposalDetailsDTO
import org.israelgda.services.ProposalService

@Path("/api/proposal")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class ProposalController {

    @Inject
    lateinit var jwt: JsonWebToken

    @Inject
    lateinit var proposalService: ProposalService

    @GET
    @RolesAllowed("manager", "user")
    @Path("/{id}")
    fun findProposalDetailed(@PathParam("id") id: Long): Response {
        return Response.ok()
            .entity(proposalService.findFullProposalDetails(id))
            .build()
    }

    @POST
    @RolesAllowed("proposal-customer")
    @Transactional
    fun create(proposalDetailsDTO: ProposalDetailsDTO): Response {
        proposalService.create(proposalDetailsDTO)

        return Response.ok().build()
    }

    @DELETE
    @RolesAllowed("manager")
    @Path("/{id}")
    @Transactional
    fun delete(@PathParam("id") id: Long): Response {
        proposalService.delete(id)
        return Response.noContent().build()
    }
}