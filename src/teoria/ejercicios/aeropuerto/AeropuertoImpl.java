package teoria.ejercicios.aeropuerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
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
	public void desviaVuelosCiudad(String ciudad, String nuevaCiudad) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public Map<LocalDate, List<Vuelo>> getVuelosPorFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Set<String>> getModelosPorCompanyia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Long> getNumeroVuelosPorCiudad() {
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
	public Map<String, Vuelo> getVueloMasRetrasoPorCompanyia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Vuelo> getVueloMasTempranoPorCiudad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getPorcentajeVuelosConRetrasoPorCompanyia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<LocalDate, List<String>> getNPrimerasCiudadesPorFecha(Integer n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Month, Integer> getNumeroDestinosDiferentesPorMes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModeloMasUtilizadoCompanyia(String companyia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDestinoMasVuelos() {
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
	public List<String> getCompanyiasMasRetraso(Integer n) {
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
	public void escribeCompanyias(String nombreFichero) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public Map<String, Integer> getNumeroVuelosIntegerPorCiudad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabetico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabeticoInverso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<Long>> getRetrasosPorCiudad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getRetrasoMedioPorCiudad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getEdadMaximaPasajeros() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
