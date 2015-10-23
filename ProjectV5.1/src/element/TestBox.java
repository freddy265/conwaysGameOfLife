package element;

import static org.junit.Assert.*;
import org.junit.Test;
import outils.Coord;
import regles.FabriqueCellRegle;

public class TestBox {

	@Test
	public void testSearchVoisinage() {
		FabriqueCellRegle f = new FabriqueCellRegle();
		Box tab = new Box(4, f, "Amoeba");
		for (int i = 0; i < Math.sqrt(tab.searchNbMax()); ++i) {
			for (int j = 0; j < Math.sqrt(tab.searchNbMax()); ++j) {
				Coord c = new Coord(i, j);
				assertTrue(tab.getCell(c).getEtat() == 1);
				//System.out.println(tab.searchNbCellVoisinageVi(i,j));
				assertTrue(tab.searchNbCellVoisinageVi(i,j) == 3);
				
				
			}
		}
	}

	@Test
	//Fill a 4x4 table with Fireworks Cells and set their state to one
	
	public void testMiseAJOURLines() {

		FabriqueCellRegle f = new FabriqueCellRegle();
		Box tab = new Box(16, f, "Lines");
		//tab.miseAjour();

		for (int i = 0; i < 4; ++i) {
			for (int j = 0; j < 4; ++j) {
				Coord c = new Coord(i, j);
				//System.out.println(tab.getCell(c).getEtat());
				tab.getCell(c).setEtat(1);
				assertTrue(tab.getCell(c).getEtat() == 1);
				tab.getCell(c).setVoisinage(tab.searchNbCellVoisinageVi(i, j));
			}
		}

		tab.miseAjour();
		assertTrue(tab.getCell(new Coord(0,0)).getEtat() == 2);
		assertTrue(tab.getCell(new Coord(3,3)).getEtat() == 2);
		assertTrue(tab.getCell(new Coord(1,1)).getNbVoisinage() == 8);
		tab.miseAjour();
		assertTrue(tab.getCell(new Coord(0,0)).getEtat() == 3);
		assertTrue(tab.getCell(new Coord(3,3)).getEtat() == 3);
		assertTrue(tab.getCell(new Coord(1,1)).getNbVoisinage() == 8);
		tab.miseAjour();
		assertTrue(tab.getCell(new Coord(0,0)).getEtat() == 0);
		assertTrue(tab.getCell(new Coord(3,3)).getEtat() == 0);
		assertTrue(tab.getCell(new Coord(1,1)).getNbVoisinage() == 8);
		tab.miseAjour();
		assertTrue(tab.getCell(new Coord(0,0)).getEtat() == 1);
		assertTrue(tab.getCell(new Coord(3,3)).getEtat() == 1);
		assertTrue(tab.getCell(new Coord(1,1)).getEtat() == 2);
		assertTrue(tab.getCell(new Coord(1,1)).getNbVoisinage() == 7);
		tab.miseAjour();
		tab.miseAjour();
		tab.miseAjour();
		tab.miseAjour();
		assertTrue(tab.getCell(new Coord(1,1)).getEtat() == 3);
		tab.miseAjour();
		tab.miseAjour();
		tab.miseAjour();
		tab.miseAjour();
		assertTrue(tab.getCell(new Coord(1,1)).getEtat() == 0);
		
	}
}
