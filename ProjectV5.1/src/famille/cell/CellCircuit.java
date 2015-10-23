package famille.cell;

import java.util.Random;

import element.Cell;
import famille.regle.RegleCircuit;

public class CellCircuit extends Cell {

	public CellCircuit(RegleCircuit regle) {
		super((new Random()).nextInt(regle.getDureeVie()), regle, regle
				.getRayon());
	}

	public CellCircuit(int couleur, RegleCircuit regle) {
		super(couleur, regle, regle.getRayon());
	}

	public void auguementerEtat(int i) {
		if (getEtat() < (((RegleCircuit) getRegle()).getDureeVie()))
			setEtat(getEtat() + i);
		else
			setEtat(0);
	}

	@Override
	public void miseAJour() {
		if (!getRegle().decision(this))
			auguementerEtat(1); // Augmenter l'etat 1

	}

	@Override
	public CellCircuit clone() {
		return new CellCircuit(
				((new Random()).nextInt(((RegleCircuit) getRegle())
						.getDureeVie())), (RegleCircuit) getRegle());
	}

	@Override
	public boolean comparaison(Cell c) {
		if (c.equals(this))
			return false;
		else
			return (getEtat() == c.getEtat() + 1);
	}
}
