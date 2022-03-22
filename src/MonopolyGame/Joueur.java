package MonopolyGame;

import java.util.ArrayList;

public class Joueur {
	
	//Attributes
	private String nom;
	private String code;
	private static int nbJoueurs;
	private Pion pion;
	private int solde = 500;
	
	
	//Constructor
	public Joueur(String nom, String nomPion) {
		this.nom = nom;
		nbJoueurs++;
		code = "J" + nbJoueurs;
		pion = new Pion(nomPion, this);
	}
	
	public void ajouterPion(Pion p) {
		this.pion = p;
	}
	
	public Pion getPion() {
		return this.pion;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getSolde(){
		return solde;
	}

	public void changerSolde(int somme) {
		this.solde += somme;
	}
	
}
