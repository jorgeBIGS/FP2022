package teoria.test;

import tipos.Punto;
import tipos.PuntoImpl1;
import tipos.PuntoImpl2;

public class TestPuntos {

	public static void main(String[] args) {
		Punto p1 = new PuntoImpl1(3.0, 7.0);
		mostrarDistancia(p1);
		Punto p2 = new PuntoImpl2(3.0, 7.0);
		mostrarDistancia(p2);
	}

	public static void mostrarDistancia(Punto p) {
		System.out.println(p.getDistanciaAlOrigen());
	}
}
