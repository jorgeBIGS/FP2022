package teoria.ejercicios.ovnis.test;

import java.util.ArrayList;
import java.util.List;

import teoria.ejercicios.ovnis.Avistamiento;
import teoria.ejercicios.ovnis.Avistamientos;
import teoria.utiles.Ficheros;

public class TestAvistamientos {

	public static void main(String[] args) {
		List<String> lineas = Ficheros.leeLineas("data/ovnis.csv");
		lineas.remove(0);
		List<Avistamiento> avistamientos = transformaAvistamientos(lineas);
		Avistamientos av = new Avistamientos(avistamientos);
		

	}
	
	public static List<Avistamiento> transformaAvistamientos(List<String> lineas){
		List<Avistamiento> result =new ArrayList<>();
		
		for(String linea: lineas) {
			result.add(new Avistamiento(linea));
		}
		
		
		return result;
	}

}
