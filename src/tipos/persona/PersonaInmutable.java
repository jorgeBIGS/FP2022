package tipos.persona;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public record PersonaInmutable(
		String nombre, List<String> apellidos, 
		LocalDate fechaNacimiento) {
	
	public Integer getEdad() {
		LocalDate ahora = LocalDate.now();

		Period intervalo = 
				Period.between(fechaNacimiento(), ahora);
		
		return intervalo.getYears();
	}
}
