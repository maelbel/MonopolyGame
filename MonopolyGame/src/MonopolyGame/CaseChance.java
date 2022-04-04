package MonopolyGame;

public class CaseChance extends Case implements AjouterArgent {
	int somme = 200;
    
	public CaseChance() {
	}
    
    public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Chance)\n";
		
		message += "+M" + somme;
		
		return message;
	}
    
    public int getSomme() {
    	return this.somme;
    }

	@Override
	public void ajouterArgent(Joueur joueur, int somme) {
		joueur.changerSolde(somme);
	}
}