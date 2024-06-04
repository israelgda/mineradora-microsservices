package org.israelgda.controllers

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.israelgda.services.OpportunityService
import java.time.Instant

@Path("/api/opportunity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM)
class OpportunityController {

    @Inject
    lateinit var opportunityService: OpportunityService

    @GET
    @Path("report")
    fun generateReport(): Response {
        return Response.ok(
            opportunityService.generateCSVOpportunityReport(),
            MediaType.APPLICATION_OCTET_STREAM
        ).header(
            "content-disposition",
            "attachment; filename = ${Instant.now()}-opportunidades-venda.csv"
        ).build()
    }
}