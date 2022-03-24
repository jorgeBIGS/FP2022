package teoria.ejercicios.ovnis;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import teoria.ejercicios.ovnis.auxiliar.ComparadorAvistamientoPorDuracion;

public class Avistamientos {
	private Set<Avistamiento> avistamientos;

	public Avistamientos() {
		this.avistamientos = new HashSet<>();
	}

	public Avistamientos(Collection<Avistamiento> avistamientos) {
		this.avistamientos = new HashSet<>(avistamientos);
	}

	public Set<Avistamiento> getAvistamientos() {
		return avistamientos;
	}

	public void anyadirAvistamiento(Avistamiento av) {
		avistamientos.add(av);
	}

	public Integer getNumeroAvistamientosFecha(LocalDate f) {
		Set<Avistamiento> aux = filtrarAvistamientosPorFecha(f);
		return aux.size();
	}

	private Set<Avistamiento> filtrarAvistamientosPorFecha(LocalDate f) {
		Set<Avistamiento> result = new HashSet<>();
		for (Avistamiento av : avistamientos) {
			if (av.getFecha().equals(f)) {
				result.add(av);
			}
		}
		return result;
	}

	public Set<Avistamiento> getAvistamientosCercanosUbicacion(
			Coordenada c, Double d) {
		Set<Avistamiento> result = new HashSet<>();
		for (Avistamiento av: avistamientos) {
			if(av.getUbicacion().getDistancia(c)<=d) {
				result.add(av);
			}
		}
		return result;
	}
	
	public Boolean existeAvistamientoLugarAnyo(String l, Integer a) {
		Boolean result = false;
		for(Avistamiento av: avistamientos) {
			if(av.getLugar().equals(l) && av.getAnyo().equals(a)) {
				result = true;
				break;
			}
		}
		return result;
	}

	
	
	
	public Avistamiento getAvistamientoMayorDuracion() {
		Comparator<Avistamiento> comparator = 
				new ComparadorAvistamientoPorDuracion();
		return Collections.max(avistamientos, comparator);
	}
	
	public Map<LocalDate, Set<Avistamiento>> getAvistamientosPorFecha() {
		Map<LocalDate, Set<Avistamiento>> result = new HashMap<>();

		for (Avistamiento av : avistamientos) {
			LocalDate clave = av.getFecha();
			if (!result.containsKey(clave)) {
				Set<Avistamiento> valor = new HashSet<>();
				valor.add(av);
				result.put(clave, valor);
			} else {
				result.get(clave).add(av);
			}
		}
		return result;
	}

	public Map<Integer, Long> getNumeroAvistamientosPorAnyo() {
		Map<Integer, Long> result = new HashMap<>();

		for (Avistamiento av : avistamientos) {
			Integer clave = av.getAnyo();
			if (!result.containsKey(clave)) {
				result.put(clave, 1l);
			} else {
				Long aux = result.get(clave);
				result.put(clave, aux + 1);
			}
		}
		return result;
	}

}
