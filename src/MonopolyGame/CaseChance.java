package MonopolyGame;

public class CaseChance extends Case {
	int recoitSommeArgent = 200;
    
	public CaseChance() {
	}

    public  int recoitArgent (){
        return recoitSommeArgent;
	}
    
    public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Chance)\n";
		
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