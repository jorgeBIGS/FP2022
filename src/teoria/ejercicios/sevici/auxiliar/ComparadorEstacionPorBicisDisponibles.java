package teoria.ejercicios.sevici.auxiliar;

import java.util.Comparator;

import teoria.ejercicios.sevici.Estacion;

public class ComparadorEstacionPorBicisDisponibles
	implements Comparator<Estacion> {

	
	public int compare(Estacion o1, Estacion o2) {
		
		int cmp = o1.getBicisDisponibles()
				.compareTo(o2.getBicisDisponibles());

		if(cmp == 0) {
			cmp = o1.compareTo(o2);
		}
		
		return cmp;
	}

}
