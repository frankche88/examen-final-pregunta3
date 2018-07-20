package universidad.alumnos.application.dto;

import java.util.ArrayList;
import java.util.List;

import universidad.alumnos.domain.entity.Alumno;

public class AlumnoToAlumnoDtoMapper {
	
	public AlumnoDto map(Alumno alumno) {
		
		AlumnoDto alumnoDto = new AlumnoDto();
		
		alumnoDto.setApellido(alumno.getApellido());
		
		alumnoDto.setNombre(alumno.getNombre());
		
		alumnoDto.setTipo(alumno.getTipo());
		
		alumnoDto.setMontoBeca(alumno.getBeca().getMontoBeca());
		
		alumnoDto.setId(alumno.getId());
		
		return alumnoDto;
		
	}
	
	
	public List<AlumnoDto> map(List<Alumno> alumnos) {
		
		List<AlumnoDto> dtoRet = new ArrayList<>();
		
		for (Alumno alumno : alumnos) {
			
			dtoRet.add(map(alumno));
			
		}
		
		return dtoRet;
		
	}
	
	

}
