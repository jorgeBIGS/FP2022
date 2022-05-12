package teoria.ejercicios.aeropuerto;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tipos.persona.Persona;

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
	
	public Map<String, Long> getNumeroVuelosPorCiudad() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCiudad, Collectors.counting()));
	}

	public SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabeticoInverso() {
		Comparator<String> cmp = Comparator.reverseOrder();
//		return getVuelos().stream().
//				collect(Collectors.groupingBy(Vuelo::getCiudad,
//						()->new TreeMap<>(cmp ),
//						Collectors.counting()));
		Map<String, Long> aux = getNumeroVuelosPorCiudad();
		SortedMap<String, Long> result = new TreeMap<>(cmp);
		result.putAll(aux);
		return result;
	}

	public SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabetico() {
		return getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getCiudad, TreeMap::new, Collectors.counting()));
	}

	public Map<String, Integer> getNumeroVuelosIntegerPorCiudad() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCiudad,
				Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}

	public Map<String, List<Long>> getRetrasosPorCiudad() {

		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCiudad,
				Collectors.mapping(Vuelo::getDiferenciaMinutos, Collectors.toList())));
	}

	public Map<String, Double> getRetrasoMedioPorCiudad() {

		return getVuelos().stream().collect(
				Collectors.groupingBy(Vuelo::getCiudad, Collectors.averagingLong(Vuelo::getDiferenciaMinutos)));
	}

	@Override
	public Boolean existeVueloConDestinoA(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean todosVuelosCompanyiaSinRetraso() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getEdadMaximaPasajeros() {

		Comparator<Persona> cmp = Comparator.
				comparing(Persona::getEdad).
				thenComparing(Comparator.naturalOrder());
		return getVuelos().
				stream().
				flatMap((Vuelo v) -> v.getPasajeros().stream()).
				max(cmp).
				map(Persona::getEdad).
				orElse(-1);
	}

	
}
