package MonopolyGame;

public class CaseImpot extends Case implements RetirerArgent {
	
	private int somme;
	
    public CaseImpot(int somme) {
    	this.somme = somme;
    }
    
    public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Imp�t)\n";
		
		message += "-M" + somme;
		
		return message;
	}
    
    public int getSomme() {
    	return this.somme;
    }

	@Override
	public void retirerArgent(Joueur joueur, int somme) {
		joueur.changerSolde(-somme);		
	}
    
    
}