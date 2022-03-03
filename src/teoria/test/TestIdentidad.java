package teoria.test;

public class TestIdentidad {

	public static void main(String[] args) {
		Integer i = new Integer(320);
		Integer j = i;
		
		System.out.println(i.equals(j));
		System.out.println(i == j);
		
		j = 320;
		
		System.out.println(i.equals(j));
		System.out.println(i == j);
		

	}

}
