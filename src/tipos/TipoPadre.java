package tipos;

public class TipoPadre {
	private String nombre;
	private String apellido1;

	public TipoPadre(String nombre, String apellido1) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoPadre [nombre=" + nombre + ", apellido1=" + apellido1 + "]";
	}

	
	
}
