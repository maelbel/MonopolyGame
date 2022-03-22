package MonopolyGame;

public class CasePrison extends Case {

	public CasePrison() {
	}
	
	public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Prison)\n";
		
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