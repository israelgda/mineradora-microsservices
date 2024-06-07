package org.israelgda.controllers

import io.quarkus.security.Authenticated
import jakarta.annotation.security.RolesAllowed
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.jwt.JsonWebToken
import org.israelgda.dto.OpportunityDTO
import org.israelgda.services.OpportunityService

@Path("/api/opportunity")
@Authenticated
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM)
class OpportunityController {

    @Inject
    lateinit var jwt: JsonWebToken

    @Inject
    lateinit var opportunityService: OpportunityService

    @GET
    @RolesAllowed("user", "manager")
    @Path("report")
    fun generateReport(): List<OpportunityDTO> {
        return opportunityService.generateOpportunityData()
    }
}