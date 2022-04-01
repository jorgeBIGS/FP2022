package teoria.utiles;

public class Checkers {
	public static void checkGoodCondition(Boolean condicionBuena) {
		if(!condicionBuena) {
			throw new IllegalArgumentException();
		}
	}
}
