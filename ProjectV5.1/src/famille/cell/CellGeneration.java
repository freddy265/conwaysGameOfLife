package famille.cell;

import element.Cell;
import famille.regle.RegleGeneration;

public class CellGeneration extends Cell {
	// A REFAIRE INITIALISATGION ETAT
	public CellGeneration(RegleGeneration regle) {
		super(RAYON_ETAT_CELLGENERATION, regle, RAYON_ETAT_CELLGENERATION);

	}

	private final static int RAYON_ETAT_CELLGENERATION = 1;

	// ///////***PUBLIC***////////
	@Override
	public void miseAJour() {
		if (!getRegle().decision(this))
			auguementerEtat(1); // Augmenter l'etat 1
	}

	public void auguementerEtat(int i) {
		if (getEtat() < ((RegleGeneration) getRegle()).getDureeVie())
			setEtat(getEtat() + i);
		else
			setEtat(0);
	}

}
