package org.israelgda.controller

import jakarta.annotation.security.RolesAllowed
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.ServerErrorException
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.israelgda.services.ReportService
import java.time.Instant


@Path("/api/opportunity")
@ApplicationScoped
class ReportController {

    @Inject
    lateinit var reportService: ReportService

    @GET
    @Path("/report")
    @RolesAllowed("user", "manager")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    fun generateReport(): Response {
        return try {
            Response.ok(
                reportService.generateCSVOpportunityReport(),
                MediaType.APPLICATION_OCTET_STREAM
            )
            .header(
                "content-disposition",
                "attachment; filename = " + Instant.now() + "--oportunidades-venda.csv"
            ).build()
        } catch (errorException: ServerErrorException) {
            Response.serverError().build()
        }
    }

    @GET
    @Path("/data")
    @RolesAllowed("user", "manager")
    fun generateOpportunitiesData(): Response {
        return try {
            Response.ok(
                reportService.getOpportunitiesData(),
                MediaType.APPLICATION_JSON
            ).build()
        } catch (errorException: ServerErrorException) {
            Response.serverError().build()
        }
    }

}