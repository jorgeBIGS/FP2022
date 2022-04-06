package teoria.ejercicios.sevici;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import teoria.ejercicios.ovnis.Coordenada;
import teoria.ejercicios.sevici.auxiliar.ComparadorEstacionPorBicisDisponibles;

public class RedEstacionesImpl implements RedEstaciones {

	private List<Estacion> estaciones;

	public RedEstacionesImpl(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public RedEstacionesImpl() {
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

	public List<Estacion> getEstacionesBicisDisponibles(int k) {
		List<Estacion> result = new ArrayList<>();
		for (Estacion e : estaciones) {
			if (e.getBicisDisponibles() >= k) {
				result.add(e);
			}
		}
		return result;
	}

	public SortedSet<Estacion> getEstacionesCercanas(Coordenada cs, double d) {
		SortedSet<Estacion> result = new TreeSet<>();
		for (Estacion e : getEstacionesBicisDisponibles()) {
			if (e.getUbicacion().getDistancia(cs) <= d) {
				result.add(e);
			}
		}
		return result;
	}

	public Set<Coordenada> getUbicacionEstaciones() {
		Set<Coordenada> result = new HashSet<>();
		for (Estacion e : estaciones) {
			result.add(e.getUbicacion());

		}

		return result;
	}

	public Set<Coordenada> getUbicacionEstacionesDisponibles(int k) {
		Set<Coordenada> result = new HashSet<>();
		for (Estacion e : getEstacionesBicisDisponibles(k)) {
			result.add(e.getUbicacion());

		}

		return result;
	}

	public Estacion getEstacionMasBicisDisponibles() {
		Comparator<Estacion> comparador = 
				new ComparadorEstacionPorBicisDisponibles();
		return Collections.max(estaciones, 
				comparador );
	}

}
