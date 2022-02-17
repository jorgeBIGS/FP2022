package tipos;

public class PuntoImpl2 implements Punto{
	private Double x;
	private Double y;
	
	public PuntoImpl2(Double x1, Double y1)
	{
		x = x1;
		y = y1;
	}
	
	public Double getDistanciaAlOrigen() {
		return x + y;
	}
}
