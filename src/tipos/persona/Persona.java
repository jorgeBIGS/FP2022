package tipos.persona;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//1. Definir una clase por cada tipo de objeto nuevo
public class Persona implements Comparable<Persona> {

	// 2. Definir un atributo por cada propiedad BASICA del tipo.
	private String nombre;
	private List<String> apellidos;
	private LocalDate fechaNacimiento;
	
	private void checkNombre(String nombrePotencial) {
		if(nombrePotencial == null || nombrePotencial.length()==0
				|| !Character.isAlphabetic(nombrePotencial.charAt(0))) {
			throw new IllegalArgumentException("La has liado parda");
		}
	}
	
	
	

	// 3. Definir un constructor v�lido
	public Persona(String nombre, List<String> apellidos, LocalDate fecha) {
		checkNombre(nombre);
		this.nombre = nombre;
		this.apellidos = apellidos;
		fechaNacimiento = fecha;
	}

	public Persona(String nombre) {
		this(nombre, new ArrayList<>(), LocalDate.MIN);
	}

	// 4. Definir m�todos getters y setters.
	public String getNombre() {
		return nombre;
	}

	public List<String> getApellidos() {
		return apellidos;
	}
	
	public String getPrimerApellido() {
		String result = "";
		if(getApellidos().size()>=1) {
			result = getApellidos().get(0);
		}
		return result;
	}
	
	
	public String getSegundoApellido() {
		String result = "";
		if(getApellidos().size()>=2) {
			result = getApellidos().get(1);
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setApellidos(List<String> apellidos) {
		this.apellidos = apellidos;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setNombre(String nombre) {
		checkNombre(nombre);
		this.nombre = nombre;
	}

	public Integer getEdad() {
		LocalDate ahora = LocalDate.now();

		Period intervalo = Period.between(getFechaNacimiento(), ahora);

		return intervalo.getYears();
	}

	// 5. Definir otras operaciones

	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", getEdad()=" + getEdad().toString() + "]";
	}

	public int hashCode() {
		return getNombre().hashCode() + 31 * getApellidos().hashCode();
	}

	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Persona) {
			Persona p = (Persona) o;
			result = getNombre().equals(p.getNombre()) && getApellidos().equals(p.getApellidos());
		}
		return result;
	}

	
	public int compareTo(Persona p) {
		int result = this.getPrimerApellido().compareTo(p.getPrimerApellido());
		if (result == 0) {
			result = this.getSegundoApellido().compareTo(p.getSegundoApellido());
			if (result == 0) {
				result = this.getNombre().compareTo(p.getNombre());
			}
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
