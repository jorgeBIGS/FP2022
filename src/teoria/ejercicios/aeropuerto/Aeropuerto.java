package teoria.ejercicios.aeropuerto;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public interface Aeropuerto {
	Set<Vuelo> getVuelos();

	Set<Vuelo> getVuelosCancelados();

	List<EstadoVuelo> getEstadosVuelos();

	Set<String> getCiudadesOrigenDistintas();

	Vuelo getVueloMayorRetraso();

	Map<String, Long> getNumeroVuelosPorCiudad();

	Map<String, Integer> getNumeroVuelosIntegerPorCiudad();

	SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabetico();

	SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabeticoInverso();

	Map<String, List<Long>> getRetrasosPorCiudad();

	Map<String, Double> getRetrasoMedioPorCiudad();

	Boolean existeVueloConDestinoA(String ciudad);

	Boolean todosVuelosCompanyiaSinRetraso();

	Integer getEdadMaximaPasajeros();

}