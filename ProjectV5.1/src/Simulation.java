import outils.Coord;
import outils.Divers;
import outils.Fenetre;
import element.IFabrique;
import element.Box;

public class Simulation implements Runnable {

	private static final int LARGEUR = 50, HAUTEUR = 50;
	private static final int TAILLE_CELLULE = 10; 
	private static final double PAUSE = 0.25;
	private static String nomRegle;
	private IFabrique f;

	public Simulation(IFabrique f) {
		this.f = f;
		new Thread(this).start();
	}

	public static void setNomRegle(String nomRegle) {
		Simulation.nomRegle = nomRegle;
	}

	@Override
	public void run() {

		while (true) {
			if (nomRegle == null) {
				System.out.println("ERROR NO RULE NAME");
			}
			Box t = new Box(LARGEUR*HAUTEUR, this.f, nomRegle);
			Fenetre.ouvrir("S.Mohamed & K.Nelly " + nomRegle, LARGEUR, HAUTEUR,
					TAILLE_CELLULE,f.getRegle(nomRegle).getDureeVie());
			while (Fenetre.lireCaractereNonBloquant() == Fenetre.RIEN) {
				for (int i = 0; i < Math.sqrt(t.searchNbMax()); ++i) {
					for (int j = 0; j < Math.sqrt(t.searchNbMax()); ++j) {
						Coord c = new Coord(i, j);
						Fenetre.setCouleur(i, j, t.getCell(c).getEtat());
					}
				}
				t.miseAjour();
				Fenetre.actualiser();
				Divers.pause(PAUSE);
			}
			Fenetre.fermer();
		}

	}

}
