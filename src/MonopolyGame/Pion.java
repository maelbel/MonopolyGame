package MonopolyGame;

public class Pion {

	private String nom;
	private int position;
	private Joueur proprietaire;
	private int tour = 0;
	
	public Pion(String nomPion, Joueur proprietaire) {
		this.nom = nomPion;
		this.proprietaire = proprietaire;
		this.position = 0;
	}

	public void deplacer(int ajouter) {
		position += ajouter;
		if(position>39) {
			position %= 39;
			tour += 1;
		}
	}
	
	public Joueur getProprietaire() {
		return proprietaire;
	}
	public int getPosition() {
		return this.position;
	}
	public int getTour() {
		return this.tour;
	}
	
	public String toString() {
		String message = "";
		
		message += "Nom propriétaire: " + this.getProprietaire().getNom()
				+ "\nNom pion: " + this.nom;
		
		return message;
		
	}
}
