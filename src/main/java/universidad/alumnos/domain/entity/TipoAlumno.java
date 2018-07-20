package universidad.alumnos.domain.entity;

public enum TipoAlumno {
	PREGRADO, MAESTRIA, DOCTORADO;
	
	public static TipoAlumno fromString(final String s) {
	    return TipoAlumno.valueOf(s);
	}
}
