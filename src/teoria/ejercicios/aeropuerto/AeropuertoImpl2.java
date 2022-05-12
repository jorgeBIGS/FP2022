package teoria.ejercicios.aeropuerto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
	
	public List<EstadoVuelo> getEstadoVuelos() {
		//predicate solo un argumento al ser Boolean
		//entra->sale
		Function<Vuelo,EstadoVuelo> function= Vuelo::getEstado;
				//(Vuelo v)->v.getEstado();
		return vuelos.stream().map(function).collect(Collectors.toList());
	}
	
	public Set<String> getCiudadesOrigenDistintas() {
		return getVuelos().stream().filter(v->v.getDireccion().equals(DireccionVuelo.OUT)).map(Vuelo::getCiudad).distinct().collect(Collectors.toSet());
	}
	
	public Vuelo getVueloMayorRetraso() {
		Comparator<Vuelo> comparador= Comparator.comparing(Vuelo::getDiferenciaMinutos).thenComparing(Comparator.naturalOrder()).reversed(); 
		Optional<Vuelo> optional= getVuelos().stream().max(comparador);
		return optional.orElse(null);
	}
	
	public Map<String, List<Vuelo>> getVuelosPorCiudad() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCiudad));
	}
	
}
