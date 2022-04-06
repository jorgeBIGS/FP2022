package teoria.ejercicios.ovnis.auxiliar;

import java.util.Comparator;

import teoria.ejercicios.ovnis.Avistamiento;

public class ComparadorAvistamientoPorDuracion implements Comparator<Avistamiento> {

	
	public int compare(Avistamiento o1, Avistamiento o2) {
		
		int cmp = o1.getDuracion().compareTo(o2.getDuracion());
		if(cmp == 0) {
			cmp = o1.compareTo(o2);
		}
		return cmp;
	}

}
