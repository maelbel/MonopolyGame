package MonopolyGame;

public class Pion {

	private String nom;
	private int position;
	private Joueur joueur;
	private int tour = 0;
	
	public Pion(String nomPion, Joueur joueur) {
		this.nom = nomPion;
		this.joueur = joueur;
		this.position = 0;
	}

	public void deplacer(int ajouter) {
		position += ajouter;
		if(position > 39 && tour == 1) {
			position = 0;
			tour += 1;
		} else if (position > 39) {
			position %= 39;
			tour += 1;
		}
	}
	
	public Joueur getJoueur() {
		return joueur;
	}
	public int getPosition() {
		return this.position;
	}
	public int getTour() {
		return this.tour;
	}
	
	public String toString() {
		String message = "";
		
		message += "Nom propriétaire: " + this.getJoueur().getNom()
				+ "\nNom pion: " + this.nom
				+ "\nSolde: " + this.getJoueur().getSolde();
		
		return message;
		
	}
}
