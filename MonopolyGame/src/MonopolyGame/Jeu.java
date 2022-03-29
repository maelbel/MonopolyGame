package MonopolyGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
	
	//Attributes
	private static final int NB_CASES = 40;
	private static final int NB_TOUR_MAX = 50;
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
		cases[0] = new CaseDepart();
		cases[1] = new CaseNormal("Corti", 60, 2);
		cases[2] = new Case();
		cases[3] = new CaseNormal("I prunelli di fiumorbu", 60, 4);
		cases[4] = new CaseImpot(200);
		cases[5] = new CaseNormal("Areoportu d'aiacciu", 200, 25);
		cases[6] = new CaseNormal("Furiani", 100, 6);
		cases[7] = new CaseChance();
		cases[8] = new CaseNormal("U viscuvatu", 100, 6);
		cases[9] = new CaseNormal("A penta di casinca", 100, 8);
		cases[10] = new CasePrison();
		cases[11] = new CaseNormal("U borgu", 140, 10);
		cases[12] = new CaseNormal("EDF", 150, 10);
		cases[13] = new CaseNormal("Biguglia", 140, 10);
		cases[14] = new CaseNormal("San martinu di lota", 160, 12);
		cases[15] = new CaseNormal("Gara di bastia", 200, 25);
		cases[16] = new CaseNormal("Patrimoniu", 180, 14);
		cases[17] = new Case();
		cases[18] = new CaseNormal("Bastia", 180, 14);
		cases[19] = new CaseNormal("Brando", 200, 16);
		cases[20] = new Case();
		cases[21] = new CaseNormal("E vile di pietrabugnu", 220, 18);
		cases[22] = new CaseChance();
		cases[23] = new CaseNormal("Ota", 220, 18);
		cases[24] = new CaseNormal("San gavinu d'ampugnani", 240, 20);
	    cases[25] = new CaseNormal("Portu di bunifaziu", 200, 25);
	    cases[26] = new CaseNormal("Aiacciu", 260, 22);
	    cases[27] = new CaseNormal("Lisula", 260, 22);
	    cases[28] = new CaseNormal("Acqua publica", 150, 10);
	    cases[29] = new CaseNormal("Calvi", 280, 24);
	    cases[30] = new CaseAllerEnPrison();
	    cases[31] = new CaseNormal("Sarte", 300, 26);
	    cases[32] = new CaseNormal("Prupria", 300, 26);
	    cases[33] = new Case();
	    cases[34] = new CaseNormal("Bunifaziu", 320, 28);
	    cases[35] = new CaseNormal("Gara di calvi", 200, 25);
	    cases[36] = new CaseChance();
	    cases[37] = new CaseNormal("Portivechju", 350, 35);
	    cases[38] = new CaseImpot(100);
	    cases[39] = new CaseNormal("San fiurenzu", 400, 50);
    }
	
	public void testerCase(Case mCase, Pion pion, Joueur joueur) {
		
		
		
		if(mCase instanceof CaseDepart) {
			((CaseDepart) mCase).ajouterArgent(joueur, ((CaseDepart) mCase).getSomme());
		} else if(mCase instanceof CaseImpot) {
			((CaseImpot) mCase).retirerArgent(joueur, ((CaseImpot) mCase).getSomme());
		} else if(mCase instanceof CaseChance) {
			((CaseChance) mCase).ajouterArgent(joueur, ((CaseChance) mCase).getSomme());
		} else if(mCase instanceof CaseAllerEnPrison) {
			((CaseAllerEnPrison) mCase).allerEnPrison(pion);
		} else if(mCase instanceof CaseNormal){
			
			Joueur proprio = ((CaseNormal) mCase).getProprietaire();
			
			// Si il n'y a pas de proprietaire
			if(proprio == null) {
				//On demande si il veut payer
				Scanner scanner = new Scanner(System.in);

				System.out.print("Voulez vous acheter ce bien (o/n): ");
				 
				String input = scanner.nextLine();
				
				char reponse = input.charAt(0);
			        
				if(reponse == 'o') {
					//On met le nouveau proprio et on enl�ve l'argent
					((CaseNormal) mCase).setProprietaire(joueur);
					((CaseNormal) mCase).retirerArgent(joueur, ((CaseNormal) mCase).getPrix());
					System.out.println("Vous venez d'acheter la propriété: " + ((CaseNormal) mCase).toString());
				} else {
					;
				}
			     
			} else {
				//Sinon le joueur sur cette case paye le loyer � l'autre joueur
				((CaseNormal) mCase).retirerArgent(joueur, ((CaseNormal) mCase).getLoyer());
				((CaseNormal) mCase).ajouterArgent(proprio, ((CaseNormal) mCase).getLoyer());
			}
		}
	}
	
	public void lancerJeu() {
		ArrayList<Pion> listePions = tousLesPions();
		Des de1 = new Des();
		Des de2 = new Des();
		int lancer1; int lancer2; int result; int position; int nbDouble = 0;
		Case mCase;
		boolean conditions = true;
		
		this.initialiserCase();
		
		while(nbTour < NB_TOUR_MAX) {
			for(Pion pion:listePions) {
				if(conditions) {
					
					Joueur joueur = pion.getJoueur();
					
					System.out.println("\n\nAu tour de: " + joueur.getNom());
					System.out.println("Solde: " + joueur.getSolde());
					
					// Faire [...] tant que le joueur fait un double
					do
					{
						if(pion.getTentativesSorties() == 3) {
							pion.setPrison(false);
							pion.setTentativesSorties(0);
						}
						
						lancer1 = de1.lancer();
						lancer2 = de2.lancer();
						
						System.out.println("Lancer n°1: " + lancer1 
											+ "\nLancer n°2: " + lancer2);
						
						if(lancer1 == lancer2) {
							nbDouble += 1;
							pion.setPrison(false);
							pion.setTentativesSorties(0);
						} else {
							nbDouble = 0;
						}
						if(nbDouble == 3) {
				            pion.setPosition(10);
				            pion.setPrison(true);
				            nbDouble = 0;
						}
						else if(pion.getPrison()) {
							pion.setTentativesSorties(pion.getTentativesSorties()+1);;
						} else {
							result = lancer1 + lancer2;
							pion.deplacer(result);
							position = pion.getPosition();
							mCase = cases[position];
							System.out.println("Case: " + mCase);
							testerCase(mCase, pion, joueur);
						}
				        
						System.out.println("Nouveau solde: " + joueur.getSolde());
						System.out.println("Tour N�: " + pion.getTour());
						
						if(pion.getTour() == NB_TOUR_MAX) {
							conditions = false; 
							nbDouble = 0;
							System.out.println("\n\n\n" + pion + "\nA fini en premier");
						}
						
						if(joueur.getSolde() <= 0) {
							conditions = false; 
							nbDouble = 0;
							System.out.println("\n\n\n" + joueur + " a perdu la partie");
						}
					}
					while (nbDouble > 0);
				} 
			}
		}
	}
}