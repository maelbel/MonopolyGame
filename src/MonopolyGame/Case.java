package MonopolyGame;

public class Case implements AjouterArgent, RetirerArgent {

	//Attributs
	private int numeroCase;
    private int argent;
	private static int nbCase = 0;
	private Joueur proprietaire = null;
	
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

	public Joueur getProprietaire() {
		return this.proprietaire;
	}
	
	public void ajouterArgent(Joueur joueur, int somme) {
		;
	}
	public void retirerArgent(Joueur joueur, int somme) {
		;
	}
    
}