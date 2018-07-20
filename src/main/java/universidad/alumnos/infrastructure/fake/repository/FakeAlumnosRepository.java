package universidad.alumnos.infrastructure.fake.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import universidad.alumnos.domain.entity.Alumno;
import universidad.alumnos.domain.entity.AlumnoDoctorado;
import universidad.alumnos.domain.entity.AlumnoMaestria;
import universidad.alumnos.domain.entity.AlumnoPregrado;
import universidad.alumnos.domain.entity.TipoAlumno;
import universidad.alumnos.domain.repository.AlumnosRepository;

public class FakeAlumnosRepository implements AlumnosRepository {
	
	
	private static final List<Alumno> alumnos = new ArrayList<>();
	
	static {
		
		alumnos.add(new AlumnoPregrado("1", "Fernando", "Lopez"));
		
		alumnos.add(new AlumnoPregrado("2", "Richard", "Cordova"));
		
		alumnos.add(new AlumnoPregrado("3", "Tania", "Villar"));
		
		alumnos.add(new AlumnoMaestria("4", "Nadia", "Fernadez"));
		
		alumnos.add(new AlumnoMaestria("5", "Marcel", "Amorin"));
		
		alumnos.add(new AlumnoMaestria("6", "Harold", "Rojas"));
		
		alumnos.add(new AlumnoDoctorado("7", "Nita", "Castillo"));
		
		alumnos.add(new AlumnoDoctorado("8", "Liber", "Arana"));
		
		alumnos.add(new AlumnoDoctorado("9", "Jose", "Yauri"));
		
	}
	

	@Override
	public List<Alumno> findByTipoAlumno(TipoAlumno tipo) {
		List<Alumno> alumnosByTipo = alumnos.stream()
			    .filter(p -> p.getTipo() == tipo).collect(Collectors.toList());
		
		return alumnosByTipo;
	}

	@Override
	public List<Alumno> findAll() {
		
		return alumnos;
	}

}
