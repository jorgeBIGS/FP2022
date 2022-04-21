package teoria.ejercicios.aeropuerto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		
		for(Vuelo v: getVuelos()) {
			if(v.getEstado().equals(EstadoVuelo.CANCELED)) {
				result.add(v);
			}
		}
		
		return result;
	}

	public List<EstadoVuelo> getEstadosVuelos() {
		List<EstadoVuelo> result = new ArrayList<>();
		
		for(Vuelo v: getVuelos()) {
			result.add(v.getEstado());
		}
		
		return result;
	}

	public Set<String> getCiudadesOrigenDistintas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
