package teoria.ejercicios.sevici;

import java.util.Objects;

import teoria.ejercicios.ovnis.Coordenada;
import teoria.utiles.Checkers;

public class Estacion implements Comparable<Estacion> {

	private static final String DELIM = ",";
	private String nombre;
	private Integer puestos, bicisDisponibles;
	private Coordenada ubicacion;

	public Estacion(String s) {
//		“087_PLAZA_NUEVA,40,35,37.38896647697466,-5.995294220038549”
		String[] splits = s.split(DELIM);
		Checkers.checkGoodCondition(splits.length == 5);

		String nombre = splits[0].trim();
		Integer puestos = Integer.valueOf(splits[1].trim());
		Integer bicisDisponibles = Integer.valueOf(splits[2].trim());
		Double latitud = Double.valueOf(splits[3].trim());
		Double longitud = Double.valueOf(splits[4].trim());

		Checkers.checkGoodCondition(puestos > 0);
		Checkers.checkGoodCondition(
				bicisDisponibles >= 0 
				&& bicisDisponibles <= puestos);

		this.nombre = nombre;
		this.puestos = puestos;
		this.bicisDisponibles = bicisDisponibles;
		this.ubicacion = new Coordenada(latitud, longitud);

	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacion other = (Estacion) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public Integer getBicisDisponibles() {
		return bicisDisponibles;
	}

	public void setBicisDisponibles(Integer bicisDisponibles) {
		Checkers.checkGoodCondition(
				bicisDisponibles >= 0 
				&& bicisDisponibles <= getPuestos());
		this.bicisDisponibles = bicisDisponibles;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getPuestos() {
		return puestos;
	}

	public Coordenada getUbicacion() {
		return ubicacion;
	}

	public Integer getPuestosVacios() {
		return getPuestos() - getBicisDisponibles();
	}

	public Boolean getTieneBicisDisponibles() {
		return getBicisDisponibles() >= 1;
	}

	public Estacion(String nombre, Integer puestos, Integer bicisDisponibles, Coordenada ubicacion) {
		Checkers.checkGoodCondition(puestos > 0);
		Checkers.checkGoodCondition(
				bicisDisponibles >= 0 
				&& bicisDisponibles <= puestos);
		this.nombre = nombre;
		this.puestos = puestos;
		this.bicisDisponibles = bicisDisponibles;
		this.ubicacion = ubicacion;
	}

	public int compareTo(Estacion o) {
		return getNombre().compareTo(o.getNombre());
	}

	@Override
	public String toString() {
		return "Estacion [nombre=" + nombre + ", puestos=" + puestos + ", bicisDisponibles=" + bicisDisponibles
				+ ", ubicacion=" + ubicacion + "]";
	}

}
