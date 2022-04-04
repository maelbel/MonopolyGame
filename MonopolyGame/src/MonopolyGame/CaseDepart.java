package MonopolyGame;

public class CaseDepart extends Case implements AjouterArgent {
	int somme = 200;
	
	public CaseDepart() {
	}
    
    public String toString() {
		String message = "";
		
		message += super.toString() + " (Case D�part)\n";
		
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