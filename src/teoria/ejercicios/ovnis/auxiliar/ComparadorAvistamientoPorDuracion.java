package teoria.ejercicios.ovnis.auxiliar;

import java.util.Comparator;

import teoria.ejercicios.ovnis.Avistamiento;

public class ComparadorAvistamientoPorDuracion implements Comparator<Avistamiento> {

	
	public int compare(Avistamiento o1, Avistamiento o2) {
		//TODO: Esto no está bien. Revisitar.
		return o1.getDuracion().compareTo(o2.getDuracion());
	}

}
