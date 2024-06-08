package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.israelgda.client.ReportRestClient
import org.israelgda.dtos.OpportunityDTO
import org.israelgda.utils.CSVHelper
import java.io.ByteArrayInputStream

@ApplicationScoped
class ReportServiceImpl: ReportService {

    @Inject
    @RestClient
    lateinit var reportRestClient: ReportRestClient

    override fun generateCSVOpportunityReport(): ByteArrayInputStream {
        val opportinityData = reportRestClient.requestOpportunitiesData()
        return CSVHelper.opportunityToCSV(opportinityData)
    }

    override fun getOpportunitiesData(): List<OpportunityDTO> {
        return reportRestClient.requestOpportunitiesData()
    }
}