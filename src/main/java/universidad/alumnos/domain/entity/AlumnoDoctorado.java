package universidad.alumnos.domain.entity;

import java.math.BigDecimal;

public class AlumnoDoctorado extends Alumno {

	private static final BigDecimal FACTOR = new BigDecimal("0.9");
	
	public AlumnoDoctorado(String id, String nombre, String apellido) {
		super(id, nombre, apellido);
	}

	@Override
	public BigDecimal getFactor() {
		return FACTOR;
	}

	@Override
	public TipoAlumno getTipo() {
		return TipoAlumno.DOCTORADO;
	}

}
