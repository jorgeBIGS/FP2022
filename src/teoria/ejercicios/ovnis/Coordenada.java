package teoria.ejercicios.ovnis;

import java.util.Objects;

import teoria.utiles.Checkers;

public class Coordenada implements Comparable<Coordenada> {
	private static final String DELIM = ",";
	private Double latitud, longitud;

	public Coordenada(Double latitud, Double longitud) {
		Checkers.checkGoodCondition(latitud<=90 && latitud>=-90);
		Checkers.checkGoodCondition(longitud<=180 && longitud>=-180);
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Coordenada() {
		this(0.0, 0.0);
	}

	public Coordenada(String s) {
		// “(-1.5, 0.22)”
		String[] splits = s.replace('(', ' ').replace(")", "").split(DELIM);
		Checkers.checkGoodCondition(splits.length == 2);
		Double latitud = Double.valueOf(splits[0].trim());
		Double longitud = Double.valueOf(splits[1].trim());
		
		Checkers.checkGoodCondition(latitud<=90 && latitud>=-90);
		Checkers.checkGoodCondition(longitud<=180 && longitud>=-180);
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		Checkers.checkGoodCondition(latitud<=90 && latitud>=-90);
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		Checkers.checkGoodCondition(longitud<=180 && longitud>=-180);
		this.longitud = longitud;
	}

	public Hemisferio getHemisferio() {
		Hemisferio result = Hemisferio.NORTE;
		if (latitud < 0) {
			result = Hemisferio.SUR;
		} else if (latitud.equals(0.0)) {
			result = Hemisferio.ECUADOR;
		}
		return result;
	}

	@Override
	public String toString() {
		return "Coordenada [latitud=" + latitud + ", longitud=" + longitud + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitud, longitud);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return Objects.equals(latitud, other.latitud) && Objects.equals(longitud, other.longitud);
	}

	public int compareTo(Coordenada o) {
		int result = getLatitud().compareTo(o.getLatitud());
		if (result == 0) {
			result = getLongitud().compareTo(o.getLongitud());
		}
		return result;
	}

	public Double getDistancia(Coordenada c) {
		Double x = getLatitud() - c.getLatitud();
		Double y = getLongitud() - c.getLongitud();
		return Math.sqrt(x * x + y * y);
	}

}
