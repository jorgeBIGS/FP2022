package teoria.ejercicios.aeropuerto;

import java.util.List;
import java.util.Set;

public interface Aeropuerto {
	Set<Vuelo> getVuelos();
	
	Set<Vuelo> getVuelosCancelados();
	
	List<EstadoVuelo> getEstadosVuelos();
	
	Set<String> getCiudadesOrigenDistintas();
	
	
}