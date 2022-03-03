package tipos;

public class PuntoImpl1 implements Punto {
	private static final String DELIM = ",";
	private Double x;
	private Double y;

	public PuntoImpl1(Double x1, Double y1) {
		x = x1;
		y = y1;
	}

	// (2.3, 6.3)
	public PuntoImpl1(String s) {
		// Paso 1: Trocear la cadena
		String[] splits = s.replace("(", "").replace(")", "").split(DELIM);
		// Paso 2: Comprobar número de elementos
		checkTamanyo(splits);
		// Paso 3: Generar falsos parámetros realizando las transformaciones
		// oportunas
		Double x = Double.valueOf(splits[0]);
		Double y = Double.valueOf(splits[1]);

		// Paso 4: Completar como si estuviéramos en un constructor al uso
		// usando los falsos parámetros anteriores
//		checkX(x);
//		checkY(y);
		this.x = x;
		this.y = y;
	}

	private void checkTamanyo(String[] splits) {
		if (splits.length != 2) {
			throw new IllegalArgumentException("Cadena no válida");
		}

	}

	public Double getDistanciaAlOrigen() {
		return Math.sqrt(x * x + y * y);
	}
}
