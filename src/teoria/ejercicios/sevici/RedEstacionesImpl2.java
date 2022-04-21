package teoria.ejercicios.sevici;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import teoria.ejercicios.ovnis.Coordenada;

public class RedEstacionesImpl2 implements RedEstaciones {

	private List<Estacion> estaciones;

	public RedEstacionesImpl2(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public RedEstacionesImpl2() {
		this.estaciones = new ArrayList<>();
	}

	public int hashCode() {
		return Objects.hash(estaciones);
	}

	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof RedEstaciones) {
			RedEstaciones aux = (RedEstaciones) obj;
			Objects.equals(estaciones, aux.getEstaciones());
		}
		return result;
	}

	public String toString() {
		return "RedEstaciones [estaciones=" + estaciones + "]";
	}

	public void anyadirEstacion(Estacion e) {
		estaciones.add(e);
	}

	public List<Estacion> getEstaciones() {
		return Collections.unmodifiableList(estaciones);
	}

	public Integer getNumeroEstaciones() {
		return estaciones.size();
	}

	public List<Estacion> getEstacionesBicisDisponibles() {
		return null;
	}

	public List<Estacion> getEstacionesBicisDisponibles(int k) {
		return null;
	}

	public SortedSet<Estacion> getEstacionesCercanas(Coordenada cs, double d) {
		return null;
	}

//	: obtiene un conjunto con la ubicaci�n de 
//	todas las estaciones.
	public Set<Coordenada> getUbicacionEstaciones() {
		return null;
	}

//	: obtiene un conjunto con la ubicaci�n de las estaciones que tienen un n�mero m�nimo de bicicletas disponibles.
	public Set<Coordenada> getUbicacionEstacionesDisponibles(int k) {
		return null;
	}

//	: obtiene la estaci�n que tiene m�s bicicletas 
//	disponibles
	public Estacion getEstacionMasBicisDisponibles() {
		return null;

	}

}
