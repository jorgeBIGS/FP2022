package teoria.test;

import java.util.List;
import java.util.stream.Collectors;

import teoria.utiles.Ficheros;
import tipos.Punto;
import tipos.PuntoImpl1;

public class TestFicheros {

	public static void main(String[] args) {
		List<String> lineas = Ficheros.leeLineas("./data/puntos.txt");
		System.out.println(lineas);
		List<Punto> puntos = lineas.stream().map((String s)->new PuntoImpl1(s))
				.collect(Collectors.toList());
		System.out.println(puntos);
	}

}
