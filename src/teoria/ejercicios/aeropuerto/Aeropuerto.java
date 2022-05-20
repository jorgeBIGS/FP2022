package teoria.ejercicios.aeropuerto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public interface Aeropuerto {

	Boolean existeVueloDestino(String ciudad);// indica si existe alg�n vuelo que tiene como destino la ciudad dada.

	Boolean todosVuelosCompanyiaSinRetraso(String companyia);// indica si todos los vuelos de la company�a dada son
															// puntuales (su hora efectiva es igual o anterior a su hora
															// planificada).

	Long getNumeroVuelosSalida();// obtiene el n�mero de vuelos de salida.

	Long getNumeroVuelosDestino(String ciudad);// obtiene el n�mero de vuelos que tienen como destino la ciudad dada.

	Long getNumeroVuelosCancelados();// obtiene el n�mero de vuelos cancelados.

	Long getNumeroVuelosCompanyia(String companyia); // obtiene el n�mero de vuelos operados por la company�a dada.

	Long getNumeroVuelosConRetraso();// obtiene el n�mero de vuelos con retraso, entendiendo por tales aquellos cuya
										// hora efectiva es posterior a su hora planificada. No se incluyen los vuelos
										// cancelados.

	Set<String> getCompanyiasVuelos();// obtiene un conjunto con las company�as a�reas diferentes que operan en el
										// aeropuerto.

	Long getNumeroCiudadesDestino();// obtiene el n�mero de ciudades diferentes a las que se puede volar desde el
									// aeropuerto.

	Set<String> getModelosAvionesCompanyia(String companyia);// obtiene un conjunto con los modelos de aviones
																// utilizados por una company�a dada.

	Long getMinutosRetrasoAcumuladosCompanyia(String companyia);// obtiene el retraso acumulado de todos los vuelos
																// operados por la company�a dada, en minutos. No se
																// incluyen los vuelos cancelados.

	Long getMediaMinutosRetrasoCiudad(String ciudad);// obtiene el retraso medio de todos los vuelos que tienen por
														// destino una ciudad. No se incluyen los vuelos cancelados.

	Set<DayOfWeek> getDiasSemanaConVuelosDestino(String ciudad);// obtiene los d�as de la semana en los que salen vuelos
																// hacia un destino.

	Vuelo getVueloMayorRetraso();// obtiene el vuelo con m�s minutos de retraso. En caso de igualdad, desempatar
									// por el orden natural.

	Vuelo getVueloMasTempranoDestino(String ciudad);// obtiene el vuelo con destino la ciudad dada que tiene una hora
													// planificada anterior. En caso de igualdad, desempatar por el
													// orden natural.

	Vuelo getPrimerVueloCompanyia(String companyia);// obtiene el vuelo operado por la company�a dada que tiene una hora
													// planificada anterior. En caso de igualdad, desempatar por el
													// orden natural.

	List<String> getPrimerosDestinos(Integer n);// obtiene los n primeros destinos, ordenados por fecha y hora de
												// salida.

	void desviaVuelosCiudad(String ciudad, String nuevaCiudad);// desv�a a nuevaCiudad todos los vuelos de salida que
																// tienen como destino ciudad (por ejemplo, debido a
																// condiciones meteorol�gicas adversas).

	Map<String, List<Vuelo>> getVuelosPorCiudad();// obtiene un Map que relaciona las ciudades con los vuelos que tienen
													// como origen o destino dicha ciudad.

	Map<LocalDate, List<Vuelo>> getVuelosPorFecha();// obtiene un Map que relaciona las fechas con los vuelos que salen
													// o llegan en esa fecha.

	Map<String, Set<String>> getModelosPorCompanyia();// obtiene un Map que relaciona las company�as con el conjunto de
														// modelos de avi�n de la company�a.

	Map<String, Long> getNumeroVuelosPorCiudad();// obtiene un Map que relaciona las ciudades con el n�mero de vuelos
													// que tienen por origen o destino dicha ciudad.

	Map<String, Integer> getNumeroVuelosConRetrasoPorCompanyia();// obtiene un Map que relaciona las company�as con el
																	// n�mero de vuelos con retraso de la company�a.

	SortedMap<Integer, Long> getNumeroSalidasPorHora();// obtiene un SortedMap que relaciona cada hora del d�a con el
														// n�mero de salidas que se producen en dicha hora, en orden
														// creciente de hora.

	Map<String, Long> getRetrasoAcumuladoPorCompanyia();// obtiene un Map que relaciona las company�as con el retraso
														// acumulado de todos los vuelos de la company�a.

	Map<String, Double> getRetrasoMedioPorCompanyia();// obtiene un Map que relaciona las company�as con el retraso
														// medio de los vuelos de la company�a.

	Map<String, Vuelo> getVueloMasRetrasoPorCompanyia();// obtiene el vuelo con m�s minutos de retraso de cada
														// company�a.

	Map<String, Vuelo> getVueloMasTempranoPorCiudad();// obtiene el vuelo que sale a una hora m�s temprana con destino a
														// cada ciudad.

	Map<String, Double> getPorcentajeVuelosConRetrasoPorCompanyia();// obtiene el porcentaje de vuelos con retraso de
																	// cada company�a respecto al n�mero total de vuelos
																	// con retraso.

	Map<LocalDate, List<String>> getNPrimerasCiudadesPorFecha(Integer n);// obtiene las n primeras ciudades de los
																			// vuelos de cada fecha, ordenadas por la
																			// hora planificada de salida.

	Map<Month, Integer> getNumeroDestinosDiferentesPorMes();// obtiene el n�mero de destinos diferentes a los que hay
															// vuelos en cada mes del anyo.

	String getModeloMasUtilizadoCompanyia(String companyia);// obtiene el modelo de avi�n m�s utilizado por una
															// company�a.

	String getDestinoMasVuelos();// obtiene la ciudad a la que se dirigen m�s vuelos.

	String getCompanyiaMasOperaciones();// obtiene la company�a con m�s operaciones de vuelo del aeropuerto.

	Set<String> getCompanyiasConAlMenosNVuelos(Integer n);// obtiene las company�as que operan al menos n vuelos.

	List<String> getCompanyiasMasRetraso(Integer n);// obtiene las n company�as con m�s vuelos con retraso, de mayor a
													// menor.

	Vuelo getVueloConModelo(String modelo);// obtiene alg�n vuelo que use un modelo de avi�n dado.

	String getCompanyiaTodosVuelosConRetraso();// obtiene alguna company�a que tenga todos sus vuelos con retraso.

	void escribeDestinos(String nombreFichero, String companyia);// crea un fichero con las ciudades de destino
																	// diferentes de una company�a.

	void escribeCompanyias(String nombreFichero);// escribe un fichero con las company�as que operan en el aeropuerto.

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