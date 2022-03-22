package MonopolyGame;

import java.util.ArrayList;

public class Joueur {
	
	//Attributs
	private String nom;
	private String code;
	private static int nbJoueurs;
	private Pion pion;
	
	//Constructeur
	public Joueur(String nom, String nomPion) {
		this.nom = nom;
		nbJoueurs++;
		code = "J" + nbJoueurs;
		pion = new Pion(nomPion);
	}
}
