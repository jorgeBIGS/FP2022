package teoria.ejercicios.sevici;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import teoria.ejercicios.ovnis.Coordenada;

public interface RedEstaciones {

	void añadirEstacion(Estacion e);

	List<Estacion> getEstaciones();

	List<Estacion> getEstacionesBicisDisponibles();

	List<Estacion> getEstacionesBicisDisponibles(int k);

	SortedSet<Estacion> getEstacionesCercanas(Coordenada cs, double d);

	Set<Coordenada> getUbicacionEstaciones();

	Set<Coordenada> getUbicacionEstacionesDisponibles(int k);

	Estacion getEstacionMasBicisDisponibles();

	Integer getNumeroEstaciones();

}