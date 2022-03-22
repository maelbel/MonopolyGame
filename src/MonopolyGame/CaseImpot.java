package MonopolyGame;

public class CaseImpot extends Case {
	int payerArgent = 200;
	
    public CaseImpot() {
	}
    
    public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Impôt)\n";
		
		message += "-M" + payerArgent;
		
		return message;
	}

	@Override
	protected void recoitArgent(Joueur joueur) {
		joueur.changerSolde(payerArgent);
	}

	@Override
	protected void retirerArgent(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}
    
    
}