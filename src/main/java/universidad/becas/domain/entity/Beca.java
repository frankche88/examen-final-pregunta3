package universidad.becas.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import universidad.alumnos.domain.entity.Alumno;



public class Beca {


	private static final BigDecimal MONTO_REFERENCIAL = new BigDecimal("8500");
	
	private Alumno alumno;
	
	private Date fechaBeca;
	
	private BigDecimal montoBeca;
	
	public Beca(Alumno alumno) {
		super();
		this.alumno = alumno;
		this.fechaBeca = new Date();
		
		calcularMontoBeta();
	}
	
	
	public BigDecimal getMontoBeca() {
		return montoBeca;
	}


	private void calcularMontoBeta(){
		
		montoBeca =  MONTO_REFERENCIAL.multiply(alumno.getFactor());
		
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public Date getFechaBeca() {
		return fechaBeca;
	}
	

}
