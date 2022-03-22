package MonopolyGame;

public class CaseAllerEnPrison extends Case {

	public CaseAllerEnPrison() {
	}
    
	
	public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Allez en prison)\n";
		
		return message;
	}


	@Override
	protected void recoitArgent(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void retirerArgent(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}
}