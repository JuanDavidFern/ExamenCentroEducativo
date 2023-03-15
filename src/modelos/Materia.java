package modelos;

import java.util.Date;

public class Materia {
	private int id;
	private String nombre;
	private Nivel nivel;
	private String codigo;
	private String url;
	private boolean admiteMatricula;
	private Date fechaInicio;

	@Override
	public String toString() {
		return nombre;
	}

	public Materia(int id, String nombre, Nivel nivel, String codigo, String url, boolean admiteMatricula,
			Date fechaInicio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nivel = nivel;
		this.codigo = codigo;
		this.url = url;
		this.admiteMatricula = admiteMatricula;
		this.fechaInicio = fechaInicio;
	}

	public Materia() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isAdmiteMatricula() {
		return admiteMatricula;
	}

	public void setAdmiteMatricula(boolean admiteMatricula) {
		this.admiteMatricula = admiteMatricula;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.id == ((Materia)obj).id;
	}

}
