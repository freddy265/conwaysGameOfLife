package outils;

/**
 * Outils divers.
 */
public class Divers {
	/**
	 * Interrompt le programme un certain temps.
	 * 
	 * @param durée
	 *            durée (en seconde) de l'interruption.
	 */
	public static void pause(double durée) {
		try {
			Thread.sleep((int) (1000 * durée));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Divers() {
	}
}
