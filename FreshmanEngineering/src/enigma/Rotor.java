package enigma;

public class Rotor {
	
	private String rotorReplace;
	
	private String rotorType;
	
	private int rotorPosition;
	
	private char rotorLetter;

	public Rotor(char A, String type) {
		rotorInit(A, type);
	}
	
	public void rotorInit(char A, String type) {
		if (type.equalsIgnoreCase("commercial")) {
			if (A == 'a') {
				rotorReplace = "DMTWSILRUYQNKFEJCAZBPGXOHV";
				rotorType = "IC";
			}
			else if (A == 'b') {
				rotorReplace = "HQZGPJTMOBLNCIFDYAWVEUSRKX";
				rotorType = "IIC";
			}
			else {
				rotorReplace = "UQNTLSZFMREHDPXKIBVYGJCWOA";
				rotorType = "IIIC";
			}
		}
		else {
			if (A == 'a') {
				rotorReplace = "PEZUOHXSCVFMTBGLRINQJWAYDK";
				rotorType = "I-K";
			}
			else if (A == 'b') {
				rotorReplace = "ZOUESYDKFWPCIQXHMVBLGNJRAT";
				rotorType = "II-K";
			}
			else {
				rotorReplace = "EHRVXGAOBQUSIMZFLYNWKTPDJC";
				rotorType = "III-K";
			}
		}
	}
	
	public String getType() {
		return rotorType;
	}
	
	public String getRotorReplace() {
		return rotorReplace;
	}
	
	public int getRotorSetting() {
		return rotorPosition;
	}
	
	public void setWheel(int pos) {
		if (pos >= 26) {
			rotorPosition = pos % 26;
		}
		else if (pos < 0) {
			System.out.print("Rotor position cannot be negative, defaulting to zero.");
			rotorPosition = 0;
		}
		else {
			rotorPosition = pos;
		}
	}
	
	public void moveWheel() {
		rotorPosition = (rotorPosition + 1) % 26;
	}
	
	public char replace(int numberCode) {
		return rotorReplace.charAt((rotorPosition + numberCode) % 26);
	}
	
}
