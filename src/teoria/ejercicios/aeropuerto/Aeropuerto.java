package teoria.ejercicios.aeropuerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public interface Aeropuerto {

	Boolean existeVueloDestino(String ciudad);// indica si existe algún vuelo que tiene como destino la ciudad dada.

	Boolean todosVuelosCompanyiaSinRetraso(String companyia);// indica si todos los vuelos de la companyía dada son
															// puntuales (su hora efectiva es igual o anterior a su hora
															// planificada).

	Long getNumeroVuelosSalida();// obtiene el número de vuelos de salida.

	Long getNumeroVuelosDestino(String ciudad);// obtiene el número de vuelos que tienen como destino la ciudad dada.

	Long getNumeroVuelosCancelados();// obtiene el número de vuelos cancelados.

	Long getNumeroVuelosCompanyia(String companyia); // obtiene el número de vuelos operados por la companyía dada.

	Long getNumeroVuelosConRetraso();// obtiene el número de vuelos con retraso, entendiendo por tales aquellos cuya
										// hora efectiva es posterior a su hora planificada. No se incluyen los vuelos
										// cancelados.

	Set<String> getCompanyiasVuelos();// obtiene un conjunto con las companyías aéreas diferentes que operan en el
										// aeropuerto.

	Long getNumeroCiudadesDestino();// obtiene el número de ciudades diferentes a las que se puede volar desde el
									// aeropuerto.

	Set<String> getModelosAvionesCompanyia(String companyia);// obtiene un conjunto con los modelos de aviones
																// utilizados por una companyía dada.

	Long getMinutosRetrasoAcumuladosCompanyia(String companyia);// obtiene el retraso acumulado de todos los vuelos
																// operados por la companyía dada, en minutos. No se
																// incluyen los vuelos cancelados.

	Long getMediaMinutosRetrasoCiudad(String ciudad);// obtiene el retraso medio de todos los vuelos que tienen por
														// destino una ciudad. No se incluyen los vuelos cancelados.

	Set<DayOfWeek> getDiasSemanaConVuelosDestino(String ciudad);// obtiene los días de la semana en los que salen vuelos
																// hacia un destino.

	Vuelo getVueloMayorRetraso();// obtiene el vuelo con más minutos de retraso. En caso de igualdad, desempatar
									// por el orden natural.

	Vuelo getVueloMasTempranoDestino(String ciudad);// obtiene el vuelo con destino la ciudad dada que tiene una hora
													// planificada anterior. En caso de igualdad, desempatar por el
													// orden natural.

	Vuelo getPrimerVueloCompanyia(String companyia);// obtiene el vuelo operado por la companyía dada que tiene una hora
													// planificada anterior. En caso de igualdad, desempatar por el
													// orden natural.

	List<String> getPrimerosDestinos(Integer n);// obtiene los n primeros destinos, ordenados por fecha y hora de
												// salida.

	void desviaVuelosCiudad(String ciudad, String nuevaCiudad);// desvía a nuevaCiudad todos los vuelos de salida que
																// tienen como destino ciudad (por ejemplo, debido a
																// condiciones meteorológicas adversas).

	Map<String, List<Vuelo>> getVuelosPorCiudad();// obtiene un Map que relaciona las ciudades con los vuelos que tienen
													// como origen o destino dicha ciudad.

	Map<LocalDate, List<Vuelo>> getVuelosPorFecha();// obtiene un Map que relaciona las fechas con los vuelos que salen
													// o llegan en esa fecha.

	Map<String, Set<String>> getModelosPorCompanyia();// obtiene un Map que relaciona las companyías con el conjunto de
														// modelos de avión de la companyía.

	Map<String, Long> getNumeroVuelosPorCiudad();// obtiene un Map que relaciona las ciudades con el número de vuelos
													// que tienen por origen o destino dicha ciudad.

	Map<String, Integer> getNumeroVuelosConRetrasoPorCompanyia();// obtiene un Map que relaciona las companyías con el
																	// número de vuelos con retraso de la companyía.

	SortedMap<Integer, Long> getNumeroSalidasPorHora();// obtiene un SortedMap que relaciona cada hora del día con el
														// número de salidas que se producen en dicha hora, en orden
														// creciente de hora.

	Map<String, Long> getRetrasoAcumuladoPorCompanyia();// obtiene un Map que relaciona las companyías con el retraso
														// acumulado de todos los vuelos de la companyía.

	Map<String, Double> getRetrasoMedioPorCompanyia();// obtiene un Map que relaciona las companyías con el retraso
														// medio de los vuelos de la companyía.

	Map<String, Vuelo> getVueloMasRetrasoPorCompanyia();// obtiene el vuelo con más minutos de retraso de cada
														// companyía.

	Map<String, Vuelo> getVueloMasTempranoPorCiudad();// obtiene el vuelo que sale a una hora más temprana con destino a
														// cada ciudad.

	Map<String, Double> getPorcentajeVuelosConRetrasoPorCompanyia();// obtiene el porcentaje de vuelos con retraso de
																	// cada companyía respecto al número total de vuelos
																	// con retraso.

	Map<LocalDate, List<String>> getNPrimerasCiudadesPorFecha(Integer n);// obtiene las n primeras ciudades de los
																			// vuelos de cada fecha, ordenadas por la
																			// hora planificada de salida.

	Map<Month, Integer> getNumeroDestinosDiferentesPorMes();// obtiene el número de destinos diferentes a los que hay
															// vuelos en cada mes del anyo.

	String getModeloMasUtilizadoCompanyia(String companyia);// obtiene el modelo de avión más utilizado por una
															// companyía.

	String getDestinoMasVuelos();// obtiene la ciudad a la que se dirigen más vuelos.

	String getCompanyiaMasOperaciones();// obtiene la companyía con más operaciones de vuelo del aeropuerto.

	Set<String> getCompanyiasConAlMenosNVuelos(Integer n);// obtiene las companyías que operan al menos n vuelos.

	List<String> getCompanyiasMasRetraso(Integer n);// obtiene las n companyías con más vuelos con retraso, de mayor a
													// menor.

	Vuelo getVueloConModelo(String modelo);// obtiene algún vuelo que use un modelo de avión dado.

	String getCompanyiaTodosVuelosConRetraso();// obtiene alguna companyía que tenga todos sus vuelos con retraso.

	void escribeDestinos(String nombreFichero, String companyia);// crea un fichero con las ciudades de destino
																	// diferentes de una companyía.

	void escribeCompanyias(String nombreFichero);// escribe un fichero con las companyías que operan en el aeropuerto.

	Set<Vuelo> getVuelos();

	Set<Vuelo> getVuelosCancelados();

	List<EstadoVuelo> getEstadosVuelos();

	Set<String> getCiudadesOrigenDistintas();

	Map<String, Integer> getNumeroVuelosIntegerPorCiudad();

	SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabetico();

	SortedMap<String, Long> getNumeroVuelosPorCiudadPorOrdenAlfabeticoInverso();

	Map<String, List<Long>> getRetrasosPorCiudad();

	Map<String, Double> getRetrasoMedioPorCiudad();

	Integer getEdadMaximaPasajeros();

}