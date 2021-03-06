package universidad.common.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import universidad.common.application.EntityNotFoundResultException;
import universidad.common.application.dto.ErrorDto;
import universidad.common.application.dto.ResponseOkCommandDto;

public class ResponseHandler {
	
	private Logger logger = LoggerFactory.getLogger(ResponseHandler.class);
	
	public Response getOkCommandResponse(String message) {
		
		ResponseOkCommandDto responseOkCommandDto = new ResponseOkCommandDto(HttpStatus.CREATED_201, message);
		
		return Response.ok().entity(responseOkCommandDto).status(HttpStatus.CREATED_201).build();
    }
	
	
	
	
	public Response getOkObjectResponse(Object message) {
		
		if(message instanceof String) {
			
			Map<String, Object> responseOK = new HashMap<>();
			
			responseOK.put("message", message);
			
			return Response.ok().entity(responseOK).status(HttpStatus.OK_200).build();
		}
		
		
		
		return Response.ok().entity(message).status(HttpStatus.OK_200).build();
    }
	
	public Response getAppCustomErrorResponse(String errorMessages)
    {
		logger.debug(errorMessages);
		
		
		
		ErrorDto error = new ErrorDto(HttpStatus.BAD_REQUEST_400, errorMessages);
		
        
        return Response.ok().entity(error).status(HttpStatus.BAD_REQUEST_400).build();
    }
	
	public Response getAppExceptionResponse(Throwable e)
    {
		logger.error(e.getMessage(), e);
		
		ErrorDto error = new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR_500, "Server error");
		
        return Response.ok().entity(error).status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
    }


	public Response getNotFoundObjectResponse(String message) {
		
        ErrorDto error = new ErrorDto(HttpStatus.NOT_FOUND_404, message);
        
        return Response.ok().entity(error).status(HttpStatus.NOT_FOUND_404).build();
	}


	public Response getNotFoundObjectResponse(String message, EntityNotFoundResultException e) {
		
		logger.error(e.getMessage(), e);
		return getNotFoundObjectResponse(message);
	}
}
