package element;

public interface IFabrique {
	String[] getTypes();

	Cell create(String regleChoisie);
	Regles getRegle(String regleChoisie);

}
