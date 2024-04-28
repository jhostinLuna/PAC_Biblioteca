package biblioteca;

import java.sql.Date;

public class Prestamo {
	private Integer id;
	private Date fechaPrestamo;
	private Date fechaDevoluvion;
	private int idLibro;
	private int idLector;
	public Prestamo() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getFechaDevoluvion() {
		return fechaDevoluvion;
	}
	public void setFechaDevoluvion(Date fechaDevoluvion) {
		this.fechaDevoluvion = fechaDevoluvion;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getIdLector() {
		return idLector;
	}
	public void setIdLector(int idLector) {
		this.idLector = idLector;
	}

}
