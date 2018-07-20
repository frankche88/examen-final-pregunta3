package universidad.alumnos.domain.repository;

import java.util.List;

import universidad.alumnos.domain.entity.Alumno;
import universidad.alumnos.domain.entity.TipoAlumno;

public interface AlumnosRepository {
	
	public List<Alumno> findByTipoAlumno(TipoAlumno tipo);
	
	public List<Alumno> findAll();

}
