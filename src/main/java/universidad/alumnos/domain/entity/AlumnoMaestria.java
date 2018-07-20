package universidad.alumnos.domain.entity;

import java.math.BigDecimal;

public class AlumnoMaestria extends Alumno {

	private static final BigDecimal FACTOR = new BigDecimal("0.8");
	
	public AlumnoMaestria(String id, String nombre, String apellido) {
		super(id, nombre, apellido);
	}

	@Override
	public BigDecimal getFactor() {
		return FACTOR;
	}

	@Override
	public TipoAlumno getTipo() {
		return TipoAlumno.MAESTRIA;
	}
}

