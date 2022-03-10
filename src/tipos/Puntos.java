package tipos;

import java.util.List;
import java.util.stream.Collectors;

import teoria.utiles.Ficheros;

public class Puntos {
	public static List<Punto> createPuntos(String ruta){
		List<String> lineas = Ficheros.leeLineas(ruta);
		return lineas.stream().map((String s)->new PuntoImpl1(s))
				.collect(Collectors.toList());
	}
	
	public static Punto createPunto(String s) {
		return new PuntoImpl1(s);
	}
}
