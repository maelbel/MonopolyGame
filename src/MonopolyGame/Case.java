package MonopolyGame;

public abstract class Case {

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

	protected abstract void recoitArgent(Joueur joueur);
	protected abstract void retirerArgent(Joueur joueur);


    
}