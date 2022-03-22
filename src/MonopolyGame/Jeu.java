package MonopolyGame;

import java.util.ArrayList;

public class Jeu {
	
	//Attributs
	private static final int NB_JOUEUR_MAX = 2;
	private static final int NB_CASES = 40;
	private Case[] cases;

	//Constructeur
	public Jeu(String titre, int nbEtapes, int nbObstacles) {
		this.cases = new Case[NB_CASES];
	}
	
	//Methods
	public void lancerJeu() {
		
	}
}
