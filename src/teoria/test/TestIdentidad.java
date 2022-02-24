package teoria.test;

public class TestIdentidad {

	public static void main(String[] args) {
		Integer i = 32;
		Integer j = i;
		
		System.out.println(i.equals(j));
		System.out.println(i == j);
		
		j = 32;
		
		System.out.println(i.equals(j));
		System.out.println(i == j);
		

	}

}
