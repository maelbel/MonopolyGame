package MonopolyGame;

public class Pion {

	private String nom;
	private int position;
	private Joueur joueur;
	private int tour = 0;
	private boolean prison = false;
	private int tentativesSorties = 0;
	
	public Pion(String nomPion, Joueur joueur) {
		this.nom = nomPion;
		this.joueur = joueur;
		this.position = 0;
	}

	public void deplacer(int ajouter) {
		position += ajouter;
		if(position > 39) {
			if(tour == 49) {
			position = 0;
			tour += 1;
			} else {
				position %= 39;
				tour += 1;
			}
			// Passage par la case d�part
			this.joueur.changerSolde(200);
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
	public void setPosition(int newPosition) {
		this.position = newPosition;
	}
	public boolean getPrison() {
		return this.prison;
	}
	public void setPrison(boolean bool) {
		this.prison = bool;
	}
	
	public int getTentativesSorties() {
		return this.tentativesSorties;
	}
	
	public void setTentativesSorties(int val) {
		this.tentativesSorties = val;
	}
	
	public String toString() {
		String message = "";
		
		message += "Nom joueur: " + this.getJoueur().getNom()
				+ "\nNom pion: " + this.nom;
		
		return message;
		
	}
}