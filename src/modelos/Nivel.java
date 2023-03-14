package modelos;

public class Nivel {
	private int id;
	private String descripcion;
	private CentroEducativo centro;

	public Nivel() {
		super();
	}

	public Nivel(int id, String descripcion, CentroEducativo centro) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.centro = centro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CentroEducativo getCentro() {
		return centro;
	}

	public void setCentro(CentroEducativo centro) {
		this.centro = centro;
	}
	

	@Override
	public String toString() {
		return descripcion;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.id == ((Nivel) obj).id;
	}

//	@Override
//	public String toString() {
//		return "Nivel [id=" + id + ", descripcion=" + descripcion + ", centro=" + centro + "]";
//	}

}
