package famille.regle;

import element.Cell;
import element.Regles;

public class RegleVie implements Regles {

	// ///////***PRIVATE***////////
	int[] tabSurvive;
	int[] tabNaissance;
	protected int dureeVie;
	private final static int DURE_VIE_CELLVIE = 2;

	// ///////***PUBLIC***///////

	public RegleVie(int[] tabSurvive, int[] tabNaissance) {
		this.tabSurvive = tabSurvive;
		this.tabNaissance = tabNaissance;
		this.dureeVie = DURE_VIE_CELLVIE;
	}

	public boolean decision(Cell c) {
		if (c.getEtat() > 0)
			return (getNb(c.getNbVoisinage(), getTabSurvive()));
		else
			return (getNb(c.getNbVoisinage(), getTabNaissance()));
	}

	public boolean getNb(int i, int tab[]) {
		for (int j : tab) {
			if (j == i)
				return true;
		}
		return false;
	}

	public int[] getTabSurvive() {
		return tabSurvive;
	}

	public int[] getTabNaissance() {
		return tabNaissance;
	}

	/**
	 * @return the dureeVie
	 */
	public int getDureeVie() {
		return dureeVie;
	}
}
