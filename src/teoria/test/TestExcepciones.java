package teoria.test;

public class TestExcepciones {

	public static void main(String[] args) {
		IllegalArgumentException excepcion = new IllegalArgumentException(); 
		try{
		throw excepcion;
		}
		catch(IllegalArgumentException e) {
			System.out.println("Se ha lanzado una excepcion");
		}
		System.out.println("Hola mundo");
	}

}
