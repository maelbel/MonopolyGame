package MonopolyGame;

import java.util.Random;

public class Des {
	//Variables
	private static final int NB_FACE = 6;
	private static Random r = new Random();
	
	//Constructors	
	public Des() {
	}
	
	//Methods	
	//Method to throw the dice
	public int lancer() {
		int nbRandom = r.nextInt(NB_FACE + 1 - 1) + 1;
		
		return nbRandom;
	}
}