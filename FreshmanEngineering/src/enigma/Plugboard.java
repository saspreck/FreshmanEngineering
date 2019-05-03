package enigma;

import java.util.HashMap;

public class Plugboard {
	
	HashMap<String, String> plugboard = new HashMap<String, String>();
	
	public Plugboard() {
		//empty
	}
	
	public void addPlugs(String A, String B) {
		plugboard.put(A, B);
		plugboard.put(B, A);
	}
	
	public char plugboardReplace(String A) {
		return plugboard.get(A).charAt(0);
	}
}
