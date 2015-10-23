package outils;

public class Coord {
	private int numL, numC;

	public Coord(int ligne, int colonne) {
		this.numL = ligne;
		this.numC = colonne;
	}

	public int getLigne() {
		return numL;
	}

	public int getColonne() {
		return numC;
	}

	public void setLigne(int l) {
		numL = l;
	}

	public void setColonne(int c) {
		numC = c;
	}
}
