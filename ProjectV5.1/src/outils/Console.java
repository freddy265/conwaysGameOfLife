package outils;

import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Outils ï¿½ l'usage des applications en mode console.
 */
public class Console {
	/**
	 * Indique si le buffer associï¿½ au clavier contient des donnï¿½es.
	 * 
	 * @return Vrai si des donnï¿½es sont prï¿½tes ï¿½ ï¿½tre lue.
	 */
	public static boolean clavierFrappé() {
		try {
			return kbObserver.available() > 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private static PushbackInputStream kbObserver = new PushbackInputStream(
			System.in);

	private Console() {
	}
}
