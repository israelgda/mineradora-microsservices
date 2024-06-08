package org.israelgda.services

import jakarta.enterprise.context.ApplicationScoped
import org.israelgda.dtos.OpportunityDTO
import java.io.ByteArrayInputStream

@ApplicationScoped
interface ReportService {

    fun generateCSVOpportunityReport(): ByteArrayInputStream
    fun getOpportunitiesData(): List<OpportunityDTO>
}