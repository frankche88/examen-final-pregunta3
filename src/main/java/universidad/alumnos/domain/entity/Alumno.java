package universidad.alumnos.domain.entity;

import java.math.BigDecimal;

import universidad.becas.domain.entity.Beca;

public abstract class Alumno {
	
	
	protected String id;
	protected String nombre;
	protected String apellido;
	
	protected TipoAlumno tipo;
	
	
	public abstract TipoAlumno getTipo();


	protected Beca beca;
	
	public Alumno(String id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.beca = new Beca(this);
	}


	public Beca getBeca() {
		return beca;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public String getId() {
		return id;
	}

	
	public abstract BigDecimal getFactor();

}
