package MonopolyGame;

public class CaseDepart extends Case {
	int recoitSommeArgent = 200;
	
	public CaseDepart() {
	}
    
    public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Départ)\n";
		
		message += "+M" + recoitSommeArgent;
		
		return message;
	}

	@Override
	protected void recoitArgent(Joueur joueur) {
		joueur.changerSolde(recoitSommeArgent);
	}

	@Override
	protected void retirerArgent(Joueur joueur) {
	}
}