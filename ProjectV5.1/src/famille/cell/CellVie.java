package famille.cell;

import element.Cell;
import famille.regle.RegleVie;

public class CellVie extends Cell {

	private final static int RAYON_CELLVIE = 1;
	public CellVie(int etat, RegleVie regle) {
		super(etat, regle, RAYON_CELLVIE);
	}

	@Override
	public void miseAJour() {
		if (((RegleVie) getRegle()).decision(this))
			setEtat(1);
		else
			setEtat(0);

	}
	

}
