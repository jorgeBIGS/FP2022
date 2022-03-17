package teoria.ejercicios.ovnis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Avistamientos {
	private Set<Avistamiento> avistamientos;

	public Avistamientos(List<Avistamiento> avistamientos) {
		this.avistamientos = new HashSet<>(avistamientos);
	}

	public Set<Avistamiento> getAvistamientos() {
		return avistamientos;
	}


	
	
}
