package famille.regle;

import element.Cell;
import element.Regles;

public class RegleCircuit implements Regles {

	public RegleCircuit(int seuil, int dureeVie, int rayon) {
		this.seuil = seuil;
		this.dureeVie = dureeVie;
		this.rayon = rayon;
	}

	private int seuil;
	private int dureeVie;
	private int rayon;

	@Override
	// true :ne pas changer de couleur
	public boolean decision(Cell c) {
		return (c.getNbVoisinage() > getSeuil());
	}

	public int getSeuil() {
		return seuil;
	}

	public int getDureeVie() {
		return dureeVie;
	}

	public int getRayon() {
		return rayon;
	}
}
