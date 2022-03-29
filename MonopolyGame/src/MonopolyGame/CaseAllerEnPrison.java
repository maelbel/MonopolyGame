package MonopolyGame;

public class CaseAllerEnPrison extends Case {

	public CaseAllerEnPrison() {
	}
	
	public void allerEnPrison(Pion pion) {
		pion.setPosition(10);
		pion.setPrison(true);
	}
    
	public String toString() {
		String message = "";
		
		message += super.toString() + " (Case Allez en prison)\n";
		
		return message;
	}
}