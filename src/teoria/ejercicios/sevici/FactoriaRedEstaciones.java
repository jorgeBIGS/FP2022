package teoria.ejercicios.sevici;

import java.util.ArrayList;
import java.util.List;

import teoria.utiles.Ficheros;

public class FactoriaRedEstaciones {

	public static RedEstaciones createRedEstaciones() {
		return new RedEstacionesImpl();
	}

	public static RedEstaciones createRedEstaciones(List<Estacion> l) {
		return new RedEstacionesImpl(l);
	}

	public static RedEstaciones leerRedEstaciones(String path, 
			Boolean eliminarCabecera) {
		List<Estacion> aux = new ArrayList<>();
		List<String> lineas = Ficheros.leeLineas(path);
		
		if(eliminarCabecera) {
			lineas.remove(0);
		}
		
		for(String linea: lineas) {
			aux.add(parsearEstacion(linea));
		}
		
		return createRedEstaciones(aux);
	}

	public static Estacion parsearEstacion(String lineaCSV) {
		return new Estacion(lineaCSV);
	}

}
