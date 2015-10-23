package famille.regle;

import element.Cell;

public class RegleGeneration extends RegleVie {


	// ///////***PUBLIC***///////
	public RegleGeneration(int[] tabSurvive, int[] tabNaissance, int dureeVie) {
		super(tabSurvive, tabNaissance);
		this.dureeVie = dureeVie;
	}
	
	@Override
	public boolean decision(Cell c) {
		if (c.getEtat() > 0)
			return (getNb(c.getNbVoisinage(), getTabSurvive()));
		else
			return (!getNb(c.getNbVoisinage(), getTabNaissance()));
	}

}
