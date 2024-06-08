package org.israelgda.controller

import jakarta.annotation.security.RolesAllowed
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.israelgda.dtos.ProposalDetailsDTO
import org.israelgda.services.ProposalService

@Path("/api/trade")
@ApplicationScoped
class ProposalController {

    @Inject
    lateinit var proposalService: ProposalService

    @GET
    @Path("/{id}")
    @RolesAllowed("user", "manager")
    fun getProposalDetailsById(@PathParam("id") id: Long): Response {
        return try {
            Response.ok(
                proposalService.findFullProposalDetails(id),
                MediaType.APPLICATION_JSON
            )
            .build()
        } catch (exception: ServerErrorException){
            Response.serverError().build()
        }
    }

    @POST
    @RolesAllowed("proposal-customer")
    fun createProposal(proposalDetailsDTO: ProposalDetailsDTO): Response {
        val proposalRequestStatus = proposalService.createProposal(proposalDetailsDTO).status

        return if(proposalRequestStatus > 199 || proposalRequestStatus < 205){
            Response.ok().build()
        } else {
            Response.status(proposalRequestStatus).build()
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @RolesAllowed("manager")
    fun deleteProposal(@PathParam("id") id: Long): Response {
        val proposalRequestStatus = proposalService.deleteProposal(id).status

        return if(proposalRequestStatus > 199 || proposalRequestStatus < 205){
            Response.ok().build()
        } else {
            Response.status(proposalRequestStatus).build()
        }
    }
}