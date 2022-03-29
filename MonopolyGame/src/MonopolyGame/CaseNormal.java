package MonopolyGame;

public class CaseNormal extends Case implements AjouterArgent, RetirerArgent {
	
	private String nom;
	private Joueur proprietaire = null;
	private int prix;
	private int loyer;
	
	public CaseNormal(String nom, int prix, int loyer) {
		this.nom = nom;
		this.prix = prix;
		this.loyer = loyer;
	}
	
	public int getPrix() {
		return this.prix;
	}
	
	public int getLoyer() {
		return this.loyer;
	}
	
	public Joueur getProprietaire() {
		return this.proprietaire;
	}

	public void setProprietaire(Joueur joueur){
		this.proprietaire = joueur;
	}

	public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Propriété)\n";
		
		message += "Nom: " + nom;
		
		if(this.getProprietaire() != null) {
			message += "\nLoyer: M" + loyer;
		} else {
			message += "\nPrix: M" + prix;
		}
		
		return message;
	}
	
	@Override
	public void ajouterArgent(Joueur joueur, int somme) {
		joueur.changerSolde(somme);
	}

	@Override
	public void retirerArgent(Joueur joueur, int somme) {
		joueur.changerSolde(-somme);
	}
}