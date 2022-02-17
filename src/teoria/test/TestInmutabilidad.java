package teoria.test;

import java.util.ArrayList;
import java.util.List;

public class TestInmutabilidad {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		System.out.println(lista);
		modificaLista(lista);
		System.out.println(lista);
		
		String mensaje = "Hola Mundo";
		System.out.println(mensaje);
		modificaMensaje(mensaje);
		System.out.println(mensaje);

	}
	
	public static void modificaMensaje(String pepe) {
		pepe += "... Adios!!";
		System.out.println("Dentro del modifica:" + pepe);
	}

	public static void modificaLista(List<Integer> l) {
		l.add(0);
	}

}
