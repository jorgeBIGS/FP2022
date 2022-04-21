package teoria.ejercicios.aeropuerto;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AeropuertoImpl2 implements Aeropuerto{
	private SortedSet<Vuelo> vuelos;

	public AeropuertoImpl2(Stream<Vuelo> vuelos) {
		this.vuelos = new TreeSet<>(vuelos.collect(Collectors.toSet()));
	}

	public AeropuertoImpl2() {
		vuelos = new TreeSet<>();
	}
	
	public Set<Vuelo> getVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Set<Vuelo> getVuelosCancelados() {
		Predicate<Vuelo> predicado = (Vuelo v)->
						v.getEstado().equals(EstadoVuelo.CANCELED);
		Stream<Vuelo> aux = vuelos.stream().filter(predicado);
		return aux.collect(Collectors.toSet());
	}

	public List<EstadoVuelo> getEstadosVuelos() {
		
		Function<Vuelo, EstadoVuelo> function = Vuelo::getEstado; 
				//(Vuelo v)->v.getEstado();
		return vuelos.stream().map(function).collect(Collectors.toList());
	}

	public Set<String> getCiudadesOrigenDistintas() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
