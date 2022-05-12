package teoria.ejercicios.aeropuerto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class AeropuertoImpl implements Aeropuerto {
	private SortedSet<Vuelo> vuelos;

	public SortedSet<Vuelo> getVuelos() {
		return vuelos;
	}

	public AeropuertoImpl(SortedSet<Vuelo> vuelos) {
		this.vuelos = new TreeSet<>(vuelos);
	}

	public AeropuertoImpl() {
		vuelos = new TreeSet<>();
	}

	public Set<Vuelo> getVuelosCancelados() {
		Set<Vuelo> result = new HashSet<>();

		for (Vuelo v : getVuelos()) {
			if (v.getEstado().equals(EstadoVuelo.CANCELED)) {
				result.add(v);
			}
		}

		return result;
	}

	public List<EstadoVuelo> getEstadosVuelos() {
		List<EstadoVuelo> result = new ArrayList<>();

		for (Vuelo v : getVuelos()) {
			result.add(v.getEstado());
		}

		return result;
	}

	public List<EstadoVuelo> getEstadoVuelos() {
		List<EstadoVuelo> res = new ArrayList<>();
		for (Vuelo v : getVuelos()) {
			res.add(v.getEstado());
		}
		return res;
	}

	private Set<String> transformaACiudades(Set<Vuelo> vuelosOrigen) {
		Set<String> res = new HashSet<>();
		for (Vuelo v : vuelosOrigen) {
			res.add(v.getCiudad());
		}
		return res;
	}

	private Set<Vuelo> getVuelosOrigen() {
		Set<Vuelo> res = new HashSet<>();
		for (Vuelo v : getVuelos()) {
			if (v.getDireccion().equals(DireccionVuelo.OUT)) {
				res.add(v);
			}
		}
		return res;
	}

	public Set<String> getCiudadesOrigenDistintas() {
		Set<Vuelo> vuelosOrigen = getVuelosOrigen();
		return transformaACiudades(vuelosOrigen);
	}

//	public Vuelo getVueloMayorRetraso() {
//		Vuelo res=null;
//		for(Vuelo v:getVuelos()) {
//			if(v==null || -1*v.diferenciaEnMinutos()>-1*res.diferenciaEnMinutos()) {
//				res=v;
//			}
//		}
//		return res;
//	}
	public Vuelo getVueloMayorRetraso() {
		Comparator<Vuelo> comparador = Comparator.comparing(Vuelo::getDiferenciaMinutos)
				.thenComparing(Comparator.naturalOrder()).reversed();
		return Collections.max(getVuelos(), comparador);

		// COMO FUNCIONA POR DENTRO
//		Comparator<Vuelo> comparator1=Comparator.comparing((Vuelo v)->v.diferenciaEnMinutos());
//		Comparator<Vuelo> comparator2=comparator1.thenComparing(Comparator.naturalOrder());
//		Comparator<Vuelo> comparator3=comparator2.reversed();

//		return Collections.max(getVuelos(),Comparator.comparing(v->v.diferenciaEnMinutos()));
	}

	public Map<String, List<Vuelo>> getVuelosPorCiudad() {
		Map<String, List<Vuelo>> res = new HashMap<>();
		for (Vuelo v : getVuelos()) {
			String key = v.getCiudad();
			if (!res.containsKey(key)) {
				List<Vuelo> value = new ArrayList<>();
				value.add(v);
				res.put(key, value);
			} else {
				res.get(key).add(v);
			}
		}
		return res;
	}

}
