package outils;

/**
 * Outils divers.
 */
public class Divers {
	/**
	 * Interrompt le programme un certain temps.
	 * 
	 * @param dur�e
	 *            dur�e (en seconde) de l'interruption.
	 */
	public static void pause(double dur�e) {
		try {
			Thread.sleep((int) (1000 * dur�e));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Divers() {
	}
}
