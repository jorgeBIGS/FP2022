package teoria.ejercicios.ovnis;

import java.util.ArrayList;
import java.util.List;

import teoria.utiles.Ficheros;

public class FactoriaAvistamientos {
//	: 
//	lee un fichero de 
//	avistamientos y construye un objeto de tipo Avistamientos.
//	• : crea un objeto de tipo 
//	Avistamiento a partir de una cadena de caracteres. La cadena de caracteres debe tener 
//	el mismo formato que las líneas del fichero CSV

	public static Avistamientos leerAvistamientos(String nombreFichero, Boolean eliminaCabecera) {
		List<Avistamiento> coleccionAvistamientos = new ArrayList<>();

		List<String> lineas = Ficheros.leeLineas(nombreFichero);
		
		if(eliminaCabecera) {
			lineas.remove(0);
		}
		
		for (String linea : lineas) {
			Avistamiento nuevoAvistamiento = 
					parsearAvistamiento(linea);
			coleccionAvistamientos.add(nuevoAvistamiento);
		}

		return new Avistamientos(coleccionAvistamientos);
	}

	public static Avistamiento parsearAvistamiento(String lineaCSV) {
		return new Avistamiento(lineaCSV);
	}
}
