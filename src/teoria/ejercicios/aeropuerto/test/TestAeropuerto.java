package teoria.ejercicios.aeropuerto.test;

import teoria.ejercicios.aeropuerto.Aeropuerto;
import teoria.ejercicios.aeropuerto.FactoriaAeropuerto;

public class TestAeropuerto {
	public static void main(String... args) {
		FactoriaAeropuerto.setImplementacionConBucles(true);
		Aeropuerto a1 = FactoriaAeropuerto.leerVuelos("data/SVQ.csv", true);
		System.out.println(a1.getCiudadesOrigenDistintas());
		
		FactoriaAeropuerto.setImplementacionConBucles(false);
		Aeropuerto a2 = FactoriaAeropuerto.leerVuelos("data/SVQ.csv", true);
		System.out.println(a2.getCiudadesOrigenDistintas());
	}
}
