package MonopolyGame;

import java.util.ArrayList;

public class Jeu {
	
	//Attributes
	private static final int NB_JOUEUR_MAX = 2;
	private static final int NB_CASES = 40;
	private static final int NB_TOUR_MAX = 2;
	private int nbTour = 0;
	private Case[] cases;
	private ArrayList<Joueur> listeJoueurs;

	//Constructor
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
        for(int i = 0; i < cases.length; i++) {
        	if (i == 0) {
                cases[i] = new CaseDepart();
            }
            else if(i == 4) {
            	cases[i] = new CaseImpot();
            }
            else if(i == 7 || i == 22 || i == 36) {
            	cases[i] = new CaseChance();
            }
            else if(i == 10) {
            	cases[i] = new CasePrison();
            }
            else if(i == 30) {
            	cases[i] = new CaseAllerEnPrison();
            }
            else {
            	cases[i] = new CaseNormal();
            }
        }   
    }
	
	public void lancerJeu() {
		ArrayList<Pion> listePions = tousLesPions();
		Des de1 = new Des(6);
		Des de2 = new Des(6);
		int lancer1; int lancer2; int result; int position; int nbDouble = 0;
		boolean duble = false;
		
		this.initialiserCase();
		
		while(nbTour < NB_TOUR_MAX) {
			for(Pion pion:listePions) {
				if(nbTour != NB_TOUR_MAX) {
					System.out.println("\n\nAu tour de: \n" + pion);
					Joueur joueur = pion.getJoueur();
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
						
						position = pion.getPosition();
												
						if(cases[position] == cases[0]) {
							cases[position].recoitArgent(joueur);
						} else if(cases[position] == cases[4]) {
							cases[position].retirerArgent(joueur);
						} else if(cases[position] == cases[7] 
								|| cases[position] == cases[22] 
								|| cases[position] == cases[36]) {
							cases[position].recoitArgent(joueur);
						}
						
						System.out.println("Solde: " + joueur.getSolde());
						System.out.println("Nouvelle position: " + position);
						System.out.println("Case: " + cases[position]);
						
						System.out.println("Tour N°: " + pion.getTour());
						
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
	public String afficherCases() {
		String message = "";
		int compteur = 0;
		
		for(Case c:cases) {
			message += "Case " + compteur + ": " + c.toString() + "\n\n";
			compteur += 1;
		}
		
		return message;
	}
}
