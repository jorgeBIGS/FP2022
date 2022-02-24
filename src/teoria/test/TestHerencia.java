package teoria.test;

import tipos.TipoHijo;
import tipos.TipoPadre;

public class TestHerencia {

	public static void main(String[] args) {
		TipoPadre padre = new TipoPadre("Jorge", "Garcia");
		TipoHijo hijo = new TipoHijo("Sofía", "García");
		muestraTipo(padre);
		muestraTipo(hijo);
	}
	
	public static void muestraTipo(TipoPadre p) {
		System.out.println(p);
	}

}
