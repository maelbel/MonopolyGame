package MonopolyGame;

public class Case{

	//Attributs
	private int numeroCase;
    private int argent;
	private static int nbCase = 0;
	
	//Constructeur
	public Case() {
		this.numeroCase = nbCase;
		nbCase++;
	}

	public String toString() {
		String message = "";
		
		message += "Cases n°" + this.numeroCase;
		
		return message;
	}


    
}