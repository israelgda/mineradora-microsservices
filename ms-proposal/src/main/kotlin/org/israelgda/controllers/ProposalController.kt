package org.israelgda.controllers

import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.israelgda.dto.ProposalDetailsDTO
import org.israelgda.services.ProposalService

@Path("/api/proposal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class ProposalController {

    @Inject
    lateinit var proposalService: ProposalService

    @GET
    @Path("/{id}")
    fun findProposalDetailed(@PathParam("id") id: Long): Response {
        return Response.ok()
            .entity(proposalService.findFullProposalDetails(id))
            .build()
    }

    @POST
    @Transactional
    fun create(proposalDetailsDTO: ProposalDetailsDTO): Response {
        proposalService.create(proposalDetailsDTO)

        return Response.ok().build()
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    fun delete(@PathParam("id") id: Long): Response {
        proposalService.delete(id)
        return Response.noContent().build()
    }
}