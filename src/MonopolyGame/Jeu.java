package MonopolyGame;

import java.util.ArrayList;

public class Jeu {
	
	//Attributs
	private static final int NB_JOUEUR_MAX = 2;
	private static final int NB_CASES = 40;
	private static final int NB_TOUR_MAX = 2;
	private int nbTour = 0;
	private Case[] cases;
	private ArrayList<Joueur> listeJoueurs;

	//Constructeur
	public Jeu() {
		this.cases = new Case[NB_CASES];
		this.listeJoueurs = new ArrayList<Joueur>();
	}
	
	//Methods	
	public void ajouterJoueur(Joueur j) {
		listeJoueurs.add(j);
	}
	
	public ArrayList<Pion> tousLesPions() {
		ArrayList<Pion> listeToutLesPions = new ArrayList<Pion>();
		Pion pion;
		
		for(Joueur j:listeJoueurs) {
			pion = j.getPion();
			listeToutLesPions.add(pion);
		}
		
		return listeToutLesPions;
	}
	
	public void initialiserCase() {
		
	}
	
	public void lancerJeu() {
		ArrayList<Pion> listePions = tousLesPions();
		Des de1 = new Des(6);
		Des de2 = new Des(6);
		int lancer1; int lancer2; int result; int nbDouble = 0;
		boolean duble = false;
		
		//initialiserCase();
		
		while(nbTour < NB_TOUR_MAX) {
			for(Pion pion:listePions) {
				if(nbTour != NB_TOUR_MAX) {
					System.out.println("\n\nAu tour de: \n" + pion);
					do
					{
						lancer1 = de1.lancer();
						lancer2 = de2.lancer();
						System.out.println("Lancer n°1: " + lancer1 
											+ "\nLancer n°2: " + lancer2);
						if(lancer1==lancer2) {
							duble = true;
							nbDouble += 1;
						} else {
							duble = false;
							nbDouble = 0;
						}
						result = lancer1 + lancer2;
						pion.deplacer(result);
						
						System.out.println("Nouvelle position: " + pion.getPosition());
						System.out.println("Tour N°: " + pion.getTour());
						
						// testerCase();
						
						if(pion.getTour() == NB_TOUR_MAX) {
							this.nbTour = pion.getTour();
							System.out.println("\n\n\n" + pion + "\nA fini en premier");
						}
					}
					while (duble);
				}
			}
		}
		
	}
}
