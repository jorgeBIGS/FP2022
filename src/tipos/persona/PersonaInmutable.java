package tipos.persona;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public record PersonaInmutable(
		String nombre, List<String> apellidos, 
		LocalDate fechaNacimiento) {
	public Integer edad() {
		LocalDate ahora = LocalDate.now();

		Period intervalo = 
				Period.between(fechaNacimiento(), ahora);
		
		return intervalo.getYears();
	}
}
