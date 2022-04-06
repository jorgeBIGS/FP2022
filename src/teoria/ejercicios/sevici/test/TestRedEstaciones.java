package teoria.ejercicios.sevici.test;

import java.util.List;

import teoria.ejercicios.sevici.Estacion;
import teoria.ejercicios.sevici.FactoriaRedEstaciones;
import teoria.ejercicios.sevici.RedEstaciones;

public class TestRedEstaciones {

	public static void main(String[] args) {
		RedEstaciones red = FactoriaRedEstaciones.
				leerRedEstaciones("data/estaciones.csv", true);
		
		mostrar(red.getEstacionesBicisDisponibles());
		

	}

	private static void mostrar(List<Estacion> estaciones) {
		for(Estacion e: estaciones) {
			System.out.println(e);
		}
		
	}

}
