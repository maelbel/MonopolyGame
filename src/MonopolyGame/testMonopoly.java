package MonopolyGame;

public class testMonopoly {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		
		Joueur j1 = new Joueur("Jean-Mich", "Chapeau");
		Joueur j2 = new Joueur("Alexandre", "Chieng");
		
		jeu.ajouterJoueur(j1);
		jeu.ajouterJoueur(j2);
		
		jeu.lancerJeu();
	}

}
