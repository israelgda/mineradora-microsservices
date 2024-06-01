package org.israelgda.services.exceptions

import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider

@Provider
class RuntimeExceptionMapper: ExceptionMapper<RuntimeException> {

    override fun toResponse(exception: RuntimeException): Response {
        return Response
            .status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(ExceptionSimpleMessage(exception.message))
            .build()
    }
}