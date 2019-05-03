package enigma;

public class Rotors {
	
	private Rotor A;
	private Rotor B;
	private Rotor C;
	
	
	
	
	public Rotors(char A, char B, char C, String type) {
		this.A = new Rotor(A, type);
		this.B = new Rotor(B, type);
		this.C = new Rotor(C, type);
	}
	
	public void setRotorPositions(int A, int B, int C) {
		this.A.setWheel(A);
		this.B.setWheel(B);
		this.C.setWheel(C);
	}
	
	public String encryptMessage(String message) {
		String character;
		String encrypted = "";
		int rotorPosition;
		char temp;
		
		for (int x = 0; x < message.length(); ++x) {
			character = String.valueOf(message.charAt(x));
			
			if (character.equals(" ")) {
				character = "X";
			}
			
			rotorPosition = ((int) character.toUpperCase().charAt(0)) - 65;
			temp = A.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = B.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = C.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = C.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = B.replace(rotorPosition);
			
			rotorPosition = ((int) temp) - 65;
			temp = A.replace(rotorPosition);
			
			encrypted = encrypted + temp;
			A.moveWheel();
			
			if ((x/26) >= 1 && (x&26) == 0) {
				B.moveWheel();
			}
		}
		return encrypted;
	}
	
	public String decryptMessage(String message) {
		String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String rotor1 = A.getRotorReplace();
		String rotor2 = B.getRotorReplace();
		String rotor3 = C.getRotorReplace();
		int rotor1Spacing = A.getRotorSetting();
		int rotor2Spacing = B.getRotorSetting();
		int rotor3Spacing = C.getRotorSetting();
		int temp = 0;
		
		for (int x = 0; 0 < message.length(); ++x) {
			for (int y = 0; y < 26; ++y) {
				if (message.charAt(x) == rotor1.charAt(y)) {
					temp = y;
				}
			}
			for (int y = 0; y < 26; ++y) {
				if (rotor1.charAt(temp) == rotor1.charAt(y)) {
					temp = y;
				}
			}
			
		}
		return null;
	}
}
