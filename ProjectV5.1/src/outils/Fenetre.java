package outils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Outils � l'usage des applications en mode graphique.
 * 
 * Cette classe propose un ensemble de m�thodes statiques permettant d'ouvrir
 * une Fen�tre graphique et d'y afficher des carr�s de couleur.
 * 
 * Un jeu compl�mentaire de m�thodes permet de lire les Caract�res tap�s au
 * clavier lorsque la Fen�tre graphique est active (i.e. lorsque la Fen�tre a le
 * focus).
 * 
 * IMPORTANT : A part {@link Fenetre#ouvrir}, toutes les m�thodes peuvent �tre
 * invoqu�es qu'� la seule condition qu'une Fen�tre soit ouverte. Enfin, une
 * unique Fen�tre peut �tre ouverte simultan�ment.
 */
public class Fenetre {

	/**
	 * Ouvre la Fen�tre dans laquelle seront affich�s les carr�s.
	 * 
	 * @param titre
	 *            Intitul� de la Fen�tre.
	 * @param largeur
	 *            Nombre de carr�s par ligne (> 0).
	 * @param hauteur
	 *            Nombre de carr�s par colonne (> 0).
	 * @param cellule
	 *            Taille des carr�s (en pixels) (> 0).
	 * @param couleur
	 *            Nombre de couleurs distinctes (> 0).
	 */
	public static void ouvrir(String titre, int largeur, int hauteur,
			int cellule, int couleur) {
		assert (frame == null);
		keyboard = new LinkedList<Character>();

		canevas = new Canevas(largeur, hauteur, cellule, couleur);
		canevas.setBackground(Color.WHITE);
		canevas.setPreferredSize(new Dimension(largeur * cellule, hauteur
				* cellule));

		frame = new JFrame(titre);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(new KeyRecorder(keyboard));
		frame.getContentPane().add(canevas);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Positionne la couleur d'un carr� d�sign� par son num�ro de colonne et son
	 * num�ro de ligne. Les couleurs sont aussi d�sign�es par un num�ro. Les
	 * num�ros de colonne, de ligne et de couleur commencent � z�ro et ne
	 * peuvent d�passer les limites fix�es � l'ouverture de la Fen�tre.
	 * 
	 * Le changement de couleur ne sera effectif (visible � l'�cran) qu'apr�s un
	 * appel � la m�thode {@link Fenetre#actualiser}.
	 * 
	 * @param x
	 *            Num�ro de la colonne.
	 * @param y
	 *            Num�ro de la ligne.
	 * @param c
	 *            Num�ro de la couleur.
	 */
	public static void setCouleur(int x, int y, int c) {
		canevas.setCouleur(x, y, c);
	}

	/**
	 * Met � jour la Fen�tre.
	 */
	public static void actualiser() {
		canevas.actualiser();
	}

	/**
	 * Ferme la Fen�tre.
	 */
	public static void fermer() {
		frame.dispose();
		keyboard = null;
		canevas = null;
		frame = null;
	}

	/**
	 * Lire le prochain carat�re. Les Caract�res saisis alors que la Fen�tre a
	 * le focus sont bufferis�s. La m�thode retourne les Caract�res dans l'ordre
	 * o� ils ont �t� saisis. La lecture est bloquante (i.e. si le buffer est
	 * vide, le programme attend qu'un Caract�re soit saisi).
	 * 
	 * @return Le prochain Caract�re saisi.
	 * @see Fenetre#lireCaract�reNonBloquant
	 */
	public static char lireCaractere() {
		char c;
		synchronized (keyboard) {
			while (keyboard.isEmpty())
				try {
					keyboard.wait();
				} catch (InterruptedException e) {
				}
			c = keyboard.poll();
		}
		return c;
	}

	/** Voir la m�thode {@link Fenetre#lireCaract�reNonBloquant}. */
	public static final char RIEN = KeyEvent.CHAR_UNDEFINED;

	/**
	 * Lire le prochain carat�re. Les Caract�res saisis alors que la Fen�tre a
	 * le focus sont bufferis�s. La m�thode retourne les Caract�res dans l'ordre
	 * o� ils ont �t� saisis. La lecture n'est pas bloquante. Si le buffer est
	 * vide, la valeur {@link Fenetre#RIEN} est retourn�e.
	 * 
	 * @return Le prochain Caract�re saisi ou {@link Fenetre#RIEN}.
	 * @see Fenetre#lireCaract�re
	 */
	public static char lireCaractereNonBloquant() {
		char c = RIEN;
		synchronized (keyboard) {
			if (!keyboard.isEmpty())
				c = keyboard.poll();
		}
		return c;
	}

	/* Partie priv�e ----------------------------------------------------- */

	private static JFrame frame = null;
	private static Canevas canevas = null;
	private static Queue<Character> keyboard = null;

	private Fenetre() {
	}

	private static class Canevas extends JPanel {
		private static final long serialVersionUID = 1L;
		private int hauteur, largeur, cellule;
		private Color[][] couleurs;
		private MJPalette palette;

		public Canevas(int larg, int haut, int cell, int coul) {
			assert (larg > 0 && haut > 0 && cell > 0);
			largeur = larg;
			hauteur = haut;
			cellule = cell;
			couleurs = new Color[largeur][hauteur];
			palette = new MJPalette(coul);
			for (int x = 0; x < largeur; ++x)
				Arrays.fill(couleurs[x], palette.get(0));
		}

		public void setCouleur(int x, int y, int c) {
			assert (0 <= x && x < largeur);
			assert (0 <= y && y < hauteur);
			couleurs[x][y] = palette.get(c);
		}

		public void actualiser() {
			repaint();
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			synchronized (couleurs) {
				Graphics2D g2d = (Graphics2D) g;
				for (int x = 0; x < largeur; ++x) {
					for (int y = 0; y < hauteur; ++y) {
						g2d.setColor(couleurs[x][y]);
						g2d.fill(new Rectangle2D.Double(x * cellule, y
								* cellule, cellule, cellule));
					}
				}
			}
		}
	}

	// got from Mirek's Java Cellebration
	// http://www.mirekw.com
	private static class MJPalette {
		public int nbc;
		public int[] palette; // color palette

		public MJPalette(int nbCouleurs) {
			assert (0 < nbCouleurs && nbCouleurs <= 256);
			palette = new int[256];
			nbc = nbCouleurs;
			ActivatePalette(nbCouleurs);
		}

		public Color get(int v) {
			assert (0 <= v && v < nbc);
			return new Color(palette[v]);
		}

		private int MakeRGB(int r, int g, int b) {
			return b + (g << 8) + (r << 16) + (0xff << 24);
		}

		private void ActivatePalette(int iSttCnt) {
			int i, j;
			{
				if (iSttCnt <= 16) {
					GeneratePalette(Color.yellow, Color.red, iSttCnt);
					palette[0] = Color.black.getRGB();
					// brown
				} else {
					palette[0] = 0;
					palette[1] = 16776960;
					palette[2] = 16767744;
					palette[3] = 16758528;
					palette[4] = 16749312;
					palette[5] = 16740096;
					palette[6] = 16730880;
					palette[7] = 16721664;
					palette[8] = 16711680;
					palette[9] = 15728640;
					palette[10] = 14745600;
					palette[11] = 13762560;
					palette[12] = 12779520;
					palette[13] = 11796480;
					palette[14] = 10813440;
					palette[15] = 9830400;
					palette[16] = 8388608;
					palette[17] = 8060928;
					palette[18] = 7733248;
					palette[19] = 7405568;
					palette[20] = 7077888;
					palette[21] = 6750208;
					palette[22] = 6422528;
					palette[23] = 6094848;
					palette[24] = 5308416;
					palette[25] = 4660992;
					palette[26] = 4013568;
					palette[27] = 3366144;
					palette[28] = 2718720;
					palette[29] = 2071296;
					palette[30] = 1423872;
					palette[31] = 776448;
					palette[32] = 65280;
					palette[33] = 65311;
					palette[34] = 65342;
					palette[35] = 65373;
					palette[36] = 65404;
					palette[37] = 65435;
					palette[38] = 65466;
					palette[39] = 65497;
					palette[40] = 65535;
					palette[41] = 57599;
					palette[42] = 49663;
					palette[43] = 41727;
					palette[44] = 33791;
					palette[45] = 25855;
					palette[46] = 17919;
					palette[47] = 9983;
					palette[48] = 255;
					palette[49] = 1376490;
					palette[50] = 2752725;
					palette[51] = 4128960;
					palette[52] = 5505195;
					palette[53] = 6881430;
					palette[54] = 8388736;
					palette[55] = 9180536;
					palette[56] = 9972336;
					palette[57] = 10764136;
					palette[58] = 11555936;
					palette[59] = 12347736;
					palette[60] = 13139536;
					palette[61] = 13931336;
					palette[62] = 14723136;
					palette[63] = 15514936;

					for (i = 1; i <= 3; i++) // copy colors to states 64..255
					{
						for (j = 0; j < 64; j++) {
							palette[64 * i + j] = palette[j];
						}
					}
					palette[64] = palette[66];
					palette[128] = palette[66];
					palette[192] = palette[66];

					// make it Java RGB
					for (i = 0; i < 256; i++)
						palette[i] += (0xff << 24);
				}
			}
		}

		private void GeneratePalette(Color c1, Color c2, int iSttCnt) {
			int dr, r1, r2;
			int dg, g1, g2;
			int db, b1, b2;
			int i;
			r1 = c1.getRed();
			r2 = c2.getRed();
			g1 = c1.getGreen();
			g2 = c2.getGreen();
			b1 = c1.getBlue();
			b2 = c2.getBlue();
			dr = (r2 - r1) / (iSttCnt - 1);
			dg = (g2 - g1) / (iSttCnt - 1);
			db = (b2 - b1) / (iSttCnt - 1);

			for (i = 1; i < iSttCnt; i++) {
				if ((i == iSttCnt - 1) && (iSttCnt > 2)) // the last color
				{
					palette[i] = MakeRGB(r2, g2, b2);
				} else {
					palette[i] = MakeRGB(r1 + (i - 1) * dr, g1 + (i - 1) * dg,
							b1 + (i - 1) * db);
				}
			}
		}
	}

	private static class KeyRecorder implements KeyListener {
		private final Queue<Character> file;

		public KeyRecorder(Queue<Character> file) {
			this.file = file;
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED)
				synchronized (file) {
					file.add(e.getKeyChar());
					file.notifyAll();
				}
		}
	}
}
