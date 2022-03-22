package MonopolyGame;

public class Pion {

	private String nom;
	private int position; 
	private Joueur proprietaire;
	
	public Pion(String nomPion) {
		this.nom = nomPion;
	}

	public void deplacer(int destination) {
		position = destination;
	}
}
