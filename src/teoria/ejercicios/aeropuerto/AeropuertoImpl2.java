package teoria.ejercicios.aeropuerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

import teoria.utiles.Ficheros;
import tipos.persona.Persona;

public class AeropuertoImpl2 implements Aeropuerto {
	private SortedSet<Vuelo> vuelos;

	public AeropuertoImpl2(Stream<Vuelo> vuelos) {
		this.vuelos = new TreeSet<>(vuelos.collect(Collectors.toSet()));
	}

	public AeropuertoImpl2() {
		vuelos = new TreeSet<>();
	}

	public Set<Vuelo> getVuelosCancelados() {
		Predicate<Vuelo> predicado = (Vuelo v) -> v.getEstado().equals(EstadoVuelo.CANCELED);
		Stream<Vuelo> aux = vuelos.stream().filter(predicado);
		return aux.collect(Collectors.toSet());
	}

	public List<EstadoVuelo> getEstadosVuelos() {

		Function<Vuelo, EstadoVuelo> function = Vuelo::getEstado;
		// (Vuelo v)->v.getEstado();
		return vuelos.stream().map(function).collect(Collectors.toList());
	}

	public List<EstadoVuelo> getEstadoVuelos() {
		// predicate solo un argumento al ser Boolean
		// entra->sale
		Function<Vuelo, EstadoVuelo> function = Vuelo::getEstado;
		// (Vuelo v)->v.getEstado();
		return vuelos.stream().map(function).collect(Collectors.toList());
	}

	public Set<String> getCiudadesOrigenDistintas() {
		return getVuelos().stream().filter(v -> v.getDireccion().equals(DireccionVuelo.OUT)).map(Vuelo::getCiudad)
				.distinct().collect(Collectors.toSet());
	}

	public Vuelo getVueloMayorRetraso() {
		Comparator<Vuelo> comparador = Comparator.comparing(Vuelo::getDiferenciaMinutos)
				.thenComparing(Comparator.naturalOrder()).reversed();
		Optional<Vuelo> optional = getVuelos().stream().max(comparador);
		return optional.orElse(null);
	}

	public Map<String, List<Vuelo>> getVuelosPorCiudad() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCiudad));
	}

	public Map<String, Long> getNumeroVuelosPorCiudad() {
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCiudad, Collectors.counting()));
	}
	
	public SortedMap<String, Long> getNumeroVuelosPorCiudadOrdenadosPorNumVuelos(){
		Map<String, Long> numVuelosPorCiudad = 
				getNumeroVuelosPorCiudad();
		Comparator<String> cmp = 
				Comparator.comparing(ciudad->numVuelosPorCiudad.get(ciudad));
		cmp = cmp.
				thenComparing(Comparator.naturalOrder());
		SortedMap<String, Long> result = 
				new TreeMap<>(cmp);
		result.putAll(numVuelosPorCiudad);
		return result;
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

	public Integer getEdadMaximaPasajeros() {

		Comparator<Persona> cmp = Comparator.comparing(Persona::getEdad).thenComparing(Comparator.naturalOrder());
		return getVuelos().stream().flatMap((Vuelo v) -> v.getPasajeros().stream()).max(cmp).map(Persona::getEdad)
				.orElse(-1);
	}

	public Map<String, Vuelo> getVueloMasRetrasoPorCompanyia() {
		Comparator<Vuelo> cmp = Comparator.comparing(Vuelo::getDiferenciaEnMinutos)
				.thenComparing(Comparator.naturalOrder());
		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCompanyia,
				Collectors.collectingAndThen(Collectors.maxBy(cmp), (Optional<Vuelo> v) -> v.orElse(null))));
	}

	public Map<String, List<Vuelo>> getVuelosMasRetrasoPorCompanyia(Integer n) {
		Comparator<Vuelo> cmp = Comparator.comparing(Vuelo::getDiferenciaEnMinutos)
				.thenComparing(Comparator.naturalOrder());
		Function<List<Vuelo>, List<Vuelo>> funcion = (List<Vuelo> l) -> l.stream().sorted(cmp.reversed()).limit(n)
				.collect(Collectors.toList());
		return getVuelos().stream().collect(
				Collectors.groupingBy(Vuelo::getCompanyia, Collectors.collectingAndThen(Collectors.toList(), funcion)));
	}

	public List<String> getCompanyiasMasRetraso(Integer n) {
		Map<String, List<Vuelo>> aux = getListadoVuelosRetrasadosPorCompanyia();

		Comparator<Entry<String, List<Vuelo>>> cmp = Comparator
				.comparing((Entry<String, List<Vuelo>> e) -> e.getValue().size()).reversed();

		return aux.entrySet().stream().sorted(cmp).limit(n).map(e -> e.getKey()).collect(Collectors.toList());
	}

	private Map<String, List<Vuelo>> getListadoVuelosRetrasadosPorCompanyia() {
		return getVuelos().stream().filter(v -> v.getDiferenciaEnMinutos() < 0)
				.collect(Collectors.groupingBy(Vuelo::getCompanyia));
	}

	public Map<String, Double> getPorcentajeVuelosConRetrasoPorCompanyia() {
		Map<String, List<Vuelo>> aux1 = getListadoVuelosRetrasadosPorCompanyia();
		Map<String, Long> aux2 = getVuelos().stream()
				.collect(Collectors.groupingBy(Vuelo::getCompanyia, Collectors.counting()));

		return aux1.entrySet().stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().size() * 100.0 / aux2.get(e.getKey())));
	}

	public void desviaVuelosCiudad(String ciudad, String nuevaCiudad) {
		getVuelos().stream().filter(v -> v.getDireccion().equals(DireccionVuelo.OUT) && v.getCiudad().equals(ciudad))
				.forEach(v -> v.setCiudad(nuevaCiudad));

	}

	public Map<String, Set<String>> getModelosPorCompanyia() {
//		Map<String, List<Vuelo>> aux = getVuelos().stream().collect(
		// Collectors.groupingBy(Vuelo::getCompanyia));
//		return aux.entrySet().stream()
//				.collect(Collectors.toMap(
//						e -> e.getKey(), 
//						e -> e.getValue().stream().map(Vuelo::getModeloAvion)
//						.collect(Collectors.toSet())));

		return getVuelos().stream().collect(Collectors.groupingBy(Vuelo::getCompanyia,
				Collectors.mapping(Vuelo::getModeloAvion, Collectors.toSet())));
	}

	public Map<LocalDate, List<String>> getNPrimerasCiudadesPorFecha(Integer n) {

		Comparator<Vuelo> cmp = Comparator.comparing(Vuelo::getHoraPlanificada)
				.thenComparing(Comparator.naturalOrder());
		Map<LocalDate, List<String>> aux = getVuelos().stream().sorted(cmp)
				.collect(Collectors.groupingBy(Vuelo::getFecha, Collectors.collectingAndThen(
						Collectors.mapping(Vuelo::getCiudad, Collectors.toList()), l -> l.stream().limit(n).toList())));

		return aux;
	}

	public Map<Month, Integer> getNumeroDestinosDiferentesPorMes() {

		return getVuelos().stream().filter(v -> v.getDireccion().equals(DireccionVuelo.OUT))
				.collect(Collectors.groupingBy(v -> v.getFecha().getMonth(), Collectors.mapping(Vuelo::getCiudad,
						Collectors.collectingAndThen(Collectors.toSet(), s -> s.size()))));
	}

	public String getModeloMasUtilizadoCompanyia(String companyia) {
		//1. Establecer la fuente de datos: el stream que resuelve.
		//2. Establecer secuencia de esquemas que resuelven el problema: 
		// filter, map.
		//3. Rellenar huecos con funcionales.
		return null;
	}

	public String getDestinoMasVuelos() {

		return null;
	}

	public void escribeCompanyias(String nombreFichero) {
		Set<String> companyias = getVuelos().stream().map(Vuelo::getCompanyia).collect(Collectors.toSet());
		Ficheros.escribeFichero(nombreFichero, companyias);
		
		
	}

	@Override
	public Boolean existeVueloDestino(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean todosVuelosCompanyiaSinRetraso(String companyia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getNumeroVuelosSalida() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getNumeroVuelosDestino(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getNumeroVuelosCancelados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getNumeroVuelosCompanyia(String companyia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getNumeroVuelosConRetraso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getCompanyiasVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getNumeroCiudadesDestino() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getModelosAvionesCompanyia(String companyia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getMinutosRetrasoAcumuladosCompanyia(String companyia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getMediaMinutosRetrasoCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<DayOfWeek> getDiasSemanaConVuelosDestino(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vuelo getVueloMasTempranoDestino(String ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vuelo getPrimerVueloCompanyia(String companyia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getPrimerosDestinos(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<LocalDate, List<Vuelo>> getVuelosPorFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getNumeroVuelosConRetrasoPorCompanyia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<Integer, Long> getNumeroSalidasPorHora() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> getRetrasoAcumuladoPorCompanyia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getRetrasoMedioPorCompanyia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Vuelo> getVueloMasTempranoPorCiudad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCompanyiaMasOperaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getCompanyiasConAlMenosNVuelos(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vuelo getVueloConModelo(String modelo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCompanyiaTodosVuelosConRetraso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void escribeDestinos(String nombreFichero, String companyia) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Vuelo> getVuelos() {
		// TODO Auto-generated method stub
		return null;
	}

}
