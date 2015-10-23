package outils;

import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Outils � l'usage des applications en mode console.
 */
public class Console {
	/**
	 * Indique si le buffer associ� au clavier contient des donn�es.
	 * 
	 * @return Vrai si des donn�es sont pr�tes � �tre lue.
	 */
	public static boolean clavierFrapp�() {
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
