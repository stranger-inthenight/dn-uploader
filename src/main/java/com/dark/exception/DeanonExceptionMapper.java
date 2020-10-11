package com.dark.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date: 2020-10-11
 */
@Provider
public class DeanonExceptionMapper implements ExceptionMapper<DeanonException> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeanonExceptionMapper.class);

    @Override
    public Response toResponse(DeanonException exception) {
        String message = exception.getMessage();
        LOGGER.warn("Error is occurred [{}]: ", exception.getMessage(), exception);
        return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponse(message))
                .build();
    }
}
