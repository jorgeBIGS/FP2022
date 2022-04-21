package teoria.test;

import java.util.stream.Stream;

public class TestStreams {

	public static void main(String[] args) {
		Stream<Integer> flujo = Stream.of(1,2,3);
		
		flujo.forEach((Integer x)->System.out.println(x));

	}

}
