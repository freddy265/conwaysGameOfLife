
import element.IFabrique;

import regles.FabriqueCellRegle;

public class Appli {

	public static void main(String[] args) {
		IFabrique f = new FabriqueCellRegle();

		System.out
				.println("Welcome to our humble Cell Simulation JAVA Appelet\n"
						+ "Here are some of our availble Types of Cells");
		
		new Menu(f);
	}

}
