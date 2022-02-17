package tipos;

public class Saludador {
	private String saludo;
	
	public Saludador(String s) {
		saludo = s;
	}
	
	public String getSaludo() {
		return saludo;
	}
	
	public void imprimeSaludo() {
		System.out.println(saludo);
	}
}
