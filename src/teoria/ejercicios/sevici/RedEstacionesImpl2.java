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
		if(obj instanceof RedEstaciones) {
			RedEstaciones aux = (RedEstaciones) obj;
			Objects.equals(estaciones, aux.getEstaciones());
		}
		return result;
	}

	public String toString() {
		return "RedEstaciones [estaciones=" + estaciones + "]";
	}

	
	public void añadirEstacion(Estacion e) {
		estaciones.add(e);
	}

	public List<Estacion> getEstaciones() {
		return Collections.unmodifiableList(estaciones);
	}
	

	public Integer getNumeroEstaciones() {
		return estaciones.size();
	}

	public List<Estacion> getEstacionesBicisDisponibles() {
		List<Estacion> result = new ArrayList<>();
		for (Estacion e : estaciones) {
			if (e.getTieneBicisDisponibles()) {
				result.add(e);
			}
		}
		return result;
	}

	public Collection<Estacion> getEstacionesBicisDisponibles(int k) {
		Collection<Estacion> result = new ArrayList<>();
		for (Estacion e : estaciones) {
			if (e.getBicisDisponibles() >= k) {
				result.add(e);
			}
		}
		return result;
	}
	
	public Collection<Estacion> getEstacionesCercanas(Coordenada cs, double d) {
		Collection<Estacion> result = new TreeSet<>();
		for (Estacion e : estaciones) {
			if (e.getTieneBicisDisponibles() && 
					e.getUbicacion().getDistancia(cs) <= d) {
				result.add(e);
			}
		}
		return result;
	}

//	: obtiene un conjunto con la ubicación de 
//	todas las estaciones.
	public Set<Coordenada> getUbicacionEstaciones() {
		return null;
	}

//	: obtiene un conjunto con la ubicación de las estaciones que tienen un número mínimo de bicicletas disponibles.
	public Set<Coordenada> getUbicacionEstacionesDisponibles(int k) {
		return null;
	}

//	: obtiene la estación que tiene más bicicletas 
//	disponibles
	public Estacion getEstacionMasBicisDisponibles() {
		return null;

	}


}
