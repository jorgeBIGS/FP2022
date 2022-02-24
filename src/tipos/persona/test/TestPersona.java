package tipos.persona.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tipos.persona.Persona;

public class TestPersona {

	public static void main(String[] args) {
		List<String> apellidos = new ArrayList<>();
		apellidos.add("Garc�a");
		apellidos.add("Guti�rrez");
		Persona p = new Persona("Jorge", apellidos, 
				LocalDate.of(1981, 5, 3));
		System.out.println(p);
		
		Persona p2 = new Persona("Jorge", apellidos, 
				LocalDate.of(1981, 5, 3));
		
		System.out.println(p.equals(p2));
	}

}
