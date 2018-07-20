package universidad.alumnos.api.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import universidad.alumnos.application.dto.AlumnoToAlumnoDtoMapper;
import universidad.alumnos.domain.entity.Alumno;
import universidad.alumnos.domain.entity.TipoAlumno;
import universidad.alumnos.domain.repository.AlumnosRepository;
import universidad.common.api.controller.ResponseHandler;

@Path("/api/alumnos/")
@PermitAll
public class AlumnosController {

	@Inject
	ResponseHandler responseHandler;
	
	@Inject
	AlumnosRepository alumnosRepository;
	
	@Inject
	AlumnoToAlumnoDtoMapper mapper;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		try {

			List<Alumno> response = alumnosRepository.findAll();

			return this.responseHandler.getOkObjectResponse(mapper.map(response));

		} catch (IllegalArgumentException ex) {

			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());

		} catch (Throwable ex) {

			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}

	@GET
	@Path("{tipo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBankAccount(@PathParam("tipo") TipoAlumno tipo) {

		try {
			
			System.out.println("AlumnosController.updateBankAccount()" + tipo);
			
			List<Alumno> response = alumnosRepository.findByTipoAlumno(tipo);

			return this.responseHandler.getOkObjectResponse(mapper.map(response));

		} catch (IllegalArgumentException ex) {

			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());

		} catch (Throwable ex) {

			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}

}
