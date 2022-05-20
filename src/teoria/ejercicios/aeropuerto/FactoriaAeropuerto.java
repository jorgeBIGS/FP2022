package teoria.ejercicios.aeropuerto;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import teoria.utiles.Ficheros;

public class FactoriaAeropuerto {
	private static Boolean implementacionConBucles = false;

	public static void setImplementacionConBucles(Boolean valor) {
		implementacionConBucles = valor;
	}

	public static Vuelo parsearVuelo(String lineaCSV) {
		return new Vuelo(lineaCSV);
	}

	public static Aeropuerto leerVuelos(String fichero, Boolean quitarCabecera) {
		Aeropuerto result;
		Stream<String> stream = Ficheros.leeLineas(fichero).stream();
		if (quitarCabecera) {
			stream = stream.skip(1);
		}

		SortedSet<Vuelo> vuelos = stream.map((String x) -> parsearVuelo(x)).collect(Collectors.toCollection(TreeSet::new));

		if (implementacionConBucles) {
			result = new AeropuertoImpl(vuelos);
		} else {
			result = new AeropuertoImpl2(vuelos.stream());
		}

		return result;

	}

}