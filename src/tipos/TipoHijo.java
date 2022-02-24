package tipos;

public class TipoHijo extends TipoPadre{
	
	public TipoHijo(String nombre, String apellido1) {
		super(nombre, apellido1);
	}

	@Override
	public String toString() {
		return "TipoHijo [getApellido1()=" + getApellido1() + ", getNombre()=" + getNombre() + "]";
	}

}
