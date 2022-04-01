package teoria.ejercicios.ovnis;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import teoria.utiles.Checkers;

public class Avistamiento implements Comparable<Avistamiento>{
	private static final String DELIM = ";";
	private LocalDate fecha;
	private String lugar;
	private Duration duracion;
	private Forma forma;
	private Coordenada ubicacion;
	
	public Avistamiento(String s) {
		//“21/01/2019; Sevilla; 30; CIRCULAR; (37.38, -5.97)”
		String [] splits = s.split(DELIM);
		Checkers.checkGoodCondition(splits.length==5);
		
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fecha = LocalDate.parse(splits[0].trim(), formateador);
		
		String lugar  = splits[1].trim();
		Integer minutos = Integer.valueOf(splits[2].trim());
		Duration duracion = Duration.ofMinutes(minutos);
		Forma forma = Forma.valueOf(splits[3].trim());
		Coordenada ubicacion = new Coordenada(splits[4].trim());
		
		Checkers.checkGoodCondition(!duracion.isNegative() && !duracion.isZero());
		LocalDate hoy = LocalDate.now();
		Checkers.checkGoodCondition(fecha.equals(hoy ) || fecha.isBefore(hoy));
		
		this.fecha = fecha;
		this.lugar = lugar;
		this.duracion = duracion;
		this.forma = forma;
		this.ubicacion = ubicacion;
	}

	public Avistamiento(String lugar, Duration duracion, Forma forma, Coordenada ubicacion) {
		this(LocalDate.now(), lugar, duracion, forma, ubicacion);
	}
	
	public Avistamiento(LocalDate fecha, String lugar, Duration duracion, Forma forma, Coordenada ubicacion) {
		Checkers.checkGoodCondition(!duracion.isNegative() && !duracion.isZero());
		LocalDate hoy = LocalDate.now();
		Checkers.checkGoodCondition(fecha.equals(hoy ) || fecha.isBefore(hoy));
		
		this.fecha = fecha;
		this.lugar = lugar;
		this.duracion = duracion;
		this.forma = forma;
		this.ubicacion = ubicacion;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setDuracion(Duration duracion) {
		Checkers.checkGoodCondition(!duracion.isNegative() && !duracion.isZero());
		this.duracion = duracion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public Forma getForma() {
		return forma;
	}

	public Coordenada getUbicacion() {
		return ubicacion;
	}

	public Integer getAnyo() {
		return fecha.getYear();
	}

	@Override
	public String toString() {
		return "Avistamiento [fecha=" + fecha + ", lugar=" + lugar + ", duracion=" + duracion + ", forma=" + forma
				+ ", ubicacion=" + ubicacion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, lugar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avistamiento other = (Avistamiento) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(lugar, other.lugar);
	}

	
	public int compareTo(Avistamiento o) {
		int result = getFecha().compareTo(o.getFecha());
		if(result == 0) {
			result = getLugar().compareTo(o.getLugar());
		}
		return result;
	}
	
	public Double getDistancia(Avistamiento a) {
		return getUbicacion().getDistancia(a.getUbicacion());	
	}
	
	
	
	
	
	
	
	
	
	
	
}
