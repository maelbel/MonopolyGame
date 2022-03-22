package MonopolyGame;

import java.util.Random;

public class Des {
	//Variables
	private static final int NB_FACE = 6;
	private static Random r = new Random();
	private static int nbDe = 0;
	private String code;
	
	//Constructors	
	//Constructor's when parameter nbFace was entered
	public Des(int nbFace) {
		nbDe++;
		this.code = "D" + nbDe;
	}
	
	//Methods
	//Method to get the number of face of the dice
	public int getNbFace(){
		return NB_FACE;
	}
	
	//Method to throw the dice
	public int lancer() {
		int nbRandom = r.nextInt(NB_FACE + 1 - 1) + 1;
		
		return nbRandom;
	}
	//Method to throw nbLance times the dice
	public int lancer(int nbLance) {
		
		int nbRandom;
		int lastNbRandom = 0;
		int somme = 0;
		
		for (int i=0; i<(nbLance-1);i++) {
			nbRandom = lancer();
			if(nbRandom == lastNbRandom){
				somme += lancer(2);
			} else {
				lastNbRandom = nbRandom;
				somme += nbRandom;
			}
		}
		
		return somme;
	}
}
