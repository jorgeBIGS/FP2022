package teoria.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tipos.persona.Persona;

public class TestOrdenaciones {

	public static void main(String[] args) {
	
		
		
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona("Jorge"));
		lista.add(new Persona("Juan Antonio"));
		lista.add(new Persona("Antonio"));
		System.out.println("Original:" + lista.get(0));
		Collections.sort(lista);
		System.out.println("Ordenado:" +lista.get(0));
	}

}
