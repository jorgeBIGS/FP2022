package teoria.test;

import java.util.ArrayList;
import java.util.List;

public class TestSublist {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		System.out.println(l);
		List<Integer> sl = l.subList(0, 2);
		System.out.println(sl);
		
		sl.add(2);
		System.out.println(sl);
		System.out.println(l);
		
//		muestraLista(l);

	}

	private static void muestraLista(List<Integer> l) {
		for(Integer i: l) {
			System.out.println(i);
			l.remove(i);
		}
		
	}

}
