package element;

import outils.Coord;


public class Box {

	private int nbMax;
	private Cell tableau[][];

	/* CONSTRUCTEUR */
	public Box(int nbMax, IFabrique f, String regleChoisie) {
		this.nbMax = nbMax;
		tableau = new Cell[(int) Math.sqrt(nbMax)][(int) Math.sqrt(nbMax)];
		for (int i = 0; i < Math.sqrt(nbMax); ++i) {
			for (int j = 0; j < Math.sqrt(nbMax); ++j) {
				tableau[i][j] = f.create(regleChoisie);
				tableau[i][j].setPosition(new Coord(i, j));
			}
		}
	}

	/* END CONSTRUCTEUR */

	public void miseAjour() {
		for (int i = 0; i < Math.sqrt(nbMax); ++i) {
			for (int j = 0; j < Math.sqrt(nbMax); ++j) {
				tableau[i][j].setVoisinage(searchNbCellVoisinageVi(i, j));
			}
		}

		for (int i = 0; i < Math.sqrt(nbMax); ++i) {
			for (int j = 0; j < Math.sqrt(nbMax); ++j) {
				tableau[i][j].miseAJour();
			}
		}

	}
	

	/**
	 * A function that scans for alive cells around a certain cell
	 * in the table 
	 */
	public int searchNbCellVoisinageVi(int x, int y)
			throws ArrayIndexOutOfBoundsException {
		int r, xMin, yMin, xMax, yMax, d = 0;

		r = tableau[x][y].getRayon();
		//Assert not getting out of bounds
		xMin = updateLowBound(x-r);
		xMax = updateHighBound(x+r, (int) Math.sqrt(nbMax));
		yMin= updateLowBound(y-r);
		yMax = updateHighBound(y+r, (int) Math.sqrt(nbMax)); 
		

		for (int i = xMin; i <= xMax; ++i) {
			for (int j = yMin; j <= yMax; ++j) {
				try {
					if (tableau[x][y].comparaison(tableau[i][j]))
						d += 1;
				} catch (ArrayIndexOutOfBoundsException e) {
					// rien faire
				}
			}
		}
		return d;
	}

	public Cell getCell(Coord c) {
		return tableau[c.getLigne()][c.getColonne()];
	}

	public int searchNbMax() {
		return nbMax;
	}
	
	
	/**
	 * Function that sends max when the rayon is out of bound
	 */
	private int updateHighBound(int i, int max){
		if (i >max)
			return max;
		else return i;
	}
	
	
	/**
	 * Function that sends 0 when rayon is negative
	 */
	private int updateLowBound(int i){
		if (i < 0)
			return 0;
		else return i;
	}
}
