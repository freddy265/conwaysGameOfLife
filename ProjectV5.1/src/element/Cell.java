package element;

import outils.Coord;


public abstract class Cell implements Cloneable {

	public Cell(int etat, Regles regle, int rayon) {
		this.etat = etat;
		this.regle = regle;
		this.rayon = rayon;
	}

	// ///////***PRIVATE***////////
	private int etat;
	private int nbVoisinage;
	private Coord position;
	private Regles regle;
	private int rayon;

	// ///////***PUBLIC***////////
	public abstract void miseAJour();

	public Cell clone() {
		try {
			return (Cell) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public int getNbVoisinage() {
		return nbVoisinage;
	}

	public void setVoisinage(int nbCell) {
		this.nbVoisinage = nbCell;
	}

	public int getEtat() {
		return etat;
	}

	public Regles getRegle() {
		return regle;
	}

	public void setEtat(int i) {
		etat = i;
	}

	public Coord getPosition() {
		return position;
	}

	public void setPosition(Coord co) {
		this.position = co;
	}

	public int getRayon() {
		return rayon;
	}

	
	/**
	 * A function that 
	 * @param Cell 
	 * @return True if cell is considered alive, and false when 
	 */
	public boolean comparaison(Cell c) {
		if (c.equals(this))
			return false;
		else
			return (c.getEtat() > 0);
	}

}
