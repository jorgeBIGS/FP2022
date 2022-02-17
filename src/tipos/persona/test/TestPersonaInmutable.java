package tipos.persona.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tipos.persona.PersonaInmutable;

public class TestPersonaInmutable {

	public static void main(String[] args) {
		List<String> apellidos = new ArrayList<>();
		apellidos.add("Garc�a");
		apellidos.add("Guti�rrez");
		PersonaInmutable p = new PersonaInmutable("Jorge", apellidos, 
				LocalDate.of(1981, 5, 3));
		System.out.println(p);
	}

}
