package teoria.utiles;

public class Checkers {
	public static void checkCondition(Boolean condicionBuena) {
		if(!condicionBuena) {
			throw new IllegalArgumentException();
		}
	}
}
