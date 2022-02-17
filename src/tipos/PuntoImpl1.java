package tipos;

public class PuntoImpl1 implements Punto {
	private Double x;
	private Double y;
	
	public PuntoImpl1(Double x1, Double y1)
	{
		x = x1;
		y = y1;
	}
	
	
	public Double getDistanciaAlOrigen() {
		return Math.sqrt(x*x + y*y);
	}
}
