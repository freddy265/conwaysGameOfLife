package famille;

import org.junit.Test;

import regles.circuit.FossilDebris;
import regles.circuit.LavaLamp;
import regles.generation.Snake;
import regles.generation.Xtasy;
import regles.vie.Move;

import element.Cell;
import famille.cell.CellCircuit;
import famille.cell.CellGeneration;
import famille.cell.CellVie;
import junit.framework.TestCase;

public class TestFamille extends TestCase {

	@Test
	public void testMove() {
		// TEST CELL VIVANTE
		Cell c1 = new CellVie(1, new Move());
		c1.setVoisinage(4);
		c1.miseAJour();
		assertTrue(c1.getEtat() > 0);

	}

	@Test
	public void testXtasy() {
		Cell c2 = new CellGeneration(new Xtasy());
		c2.setVoisinage(4);
		c2.miseAJour();
		assertTrue(c2.getEtat() == 2);
		c2.miseAJour();
		assertTrue(c2.getEtat() == 3);

	}

	@Test
	public void testSnake() {
		Cell c3 = new CellGeneration(new Snake());
		c3.setVoisinage(0);
		for (int i = 0; i < 5; i++, c3.miseAJour())
			;
		assertTrue(c3.getEtat() > 0);

		c3.miseAJour();
		assertFalse(c3.getEtat() > 0);
	}

	@Test
	public void testLavaLamp() {
		Cell c4 = new CellCircuit(new LavaLamp());
		c4.setVoisinage(3);
		int i = c4.getEtat();
		c4.miseAJour();
		assertTrue(c4.getEtat() == i + 1);
		Cell c7 = new CellCircuit(new LavaLamp());
		c7.setVoisinage(13);
		i = c7.getEtat();
		c7.miseAJour();
		assertTrue(c7.getEtat() == i);
	}

	@Test
	public void testFossilDebris() {
		Cell c5 = new CellCircuit(new FossilDebris());
		c5.setVoisinage(13);
		int i = c5.getEtat();
		c5.miseAJour();
		assertTrue(c5.getEtat() == i);

		Cell c6 = new CellCircuit(new FossilDebris());
		c6.setVoisinage(9);
		i = c6.getEtat();
		c6.miseAJour();
		assertTrue(c6.getEtat() == i + 1);

	}
}