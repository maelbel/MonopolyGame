package MonopolyGame;

public class Joueur {
	
	//Attributes
	private String nom;
	private Pion pion;
	private int solde = 500;
	
	
	//Constructor
	public Joueur(String nom, String nomPion) {
		this.nom = nom;
		pion = new Pion(nomPion, this);
	}
	
	public Pion getPion() {
		return this.pion;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getSolde(){
		return this.solde;
	}

	public void changerSolde(int somme) {
		this.solde = solde + somme;
	}
	
	public String toString() {
		String message = "";
		
		message += nom;
		
		return nom;
	}
	
}