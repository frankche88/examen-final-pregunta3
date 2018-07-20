package universidad.alumnos.application.dto;

import java.math.BigDecimal;

import universidad.alumnos.domain.entity.TipoAlumno;


public class AlumnoDto {
	
	private String id;
	private String nombre;
	private String apellido;
	
	private TipoAlumno tipo;
	
	private BigDecimal montoBeca;
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public TipoAlumno getTipo() {
		return tipo;
	}



	public void setTipo(TipoAlumno tipo) {
		this.tipo = tipo;
	}



	public BigDecimal getMontoBeca() {
		return montoBeca;
	}



	public void setMontoBeca(BigDecimal montoBeca) {
		this.montoBeca = montoBeca;
	}



	public AlumnoDto() {
		// TODO Auto-generated constructor stub
	}

	

}
