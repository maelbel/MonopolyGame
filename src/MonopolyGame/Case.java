package MonopolyGame;

public abstract class Case {

	//Attributs
	private int numeroCase;
	private int typeCase;
	private static int nbCase = 0;
	private String refCase;
	
	//Constructeur
	public Case(int typeCase) {
		this.numeroCase = nbCase;
		this.typeCase = typeCase;
		this.refCase = "C" + numeroCase;
		nbCase++;
	}
}
