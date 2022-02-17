package teoria.test;

import java.time.LocalDate;

public class TestLocalDate {

	public static void main(String[] args) {
		LocalDate fecha = LocalDate.of(1981, 5, 3);
		System.out.println(fecha);

		fecha = LocalDate.parse("1981-05-03");
		System.out.println(fecha);
		
	}

}
