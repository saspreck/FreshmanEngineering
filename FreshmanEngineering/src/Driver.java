import java.util.Scanner;
import enigma.Rotors;
import enigma.Plugboard;
import enigma.Rotor;
import enigma.Base;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
	
	/**
	 * print out a list of the options
	 * have the user select 
	 */
	
	public static void main (String [] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input the number of the cypher you wish to use or 0 to quit:");
		System.out.println("1. Morse code");
		System.out.println("2. Enigma");
		System.out.println("3. Backwards alphabet");
		System.out.println("4. Columnar transposition");

		int selection = keyboard.nextInt();
		keyboard.nextLine();
		
		while(selection != 0) {
	
			if(selection == 1) {
				morseCode(keyboard);
			}
			else if(selection == 2) {
				Base.enigmaRun();
			}
			else if(selection == 3) {
				backwardsAlphabet(keyboard);
			}
			else if(selection == 4) {
				columnarTransposition(keyboard);
			}
			else {
				System.out.println("Invalid input");
			}
			
			System.out.println();
			System.out.println("Input the number of the cypher you wish to use or 0 to quit:");
			System.out.println("1. Morse code");
			System.out.println("2. Enigma");
			System.out.println("3. Backwards alphabet");
			System.out.println("4. Columnar transposition");
			
			selection = keyboard.nextInt();
			keyboard.nextLine();
			
		}
	}
	
	public static void columnarTransposition(Scanner keyboard) {
		//arraylist to store each group of five characters
		ArrayList<String> substrings = new ArrayList<String>();
		
		//gets the message from the user
		System.out.println("Input your message:");
		String message = keyboard.nextLine().toLowerCase();
		
		//removes the spaces from the message
		String[] noSpaces = message.split(" ");
		String spacesRemoved = "";
		for(int i = 0; i < noSpaces.length; i++) {
			spacesRemoved += noSpaces[i];
		}
		
		//checks if the message's length is not a multiple of five
		int remainder = spacesRemoved.length() % 5;
		if(remainder != 0) {
			//if the length is not a multiple of five, adds the appropriate number of x's to make it so
			for(int i = 0; i < (5 - remainder); i++) {
				spacesRemoved += "x";
			}
		}
		
		//gets the size the arraylist needs to be
		int numGroupings = spacesRemoved.length() / 5;
		int startIndex = 0;
		int endIndex = 5;
		
		//iterates through the message and divides the message into groups of five characters
		for(int i = 0; i < numGroupings; i++){
				substrings.add(spacesRemoved.substring(startIndex, endIndex));
				startIndex += 5;
				endIndex += 5;
		}
		
		//scrambles the groupings
		for(int i = 0; i < substrings.size(); i++) {
			//puts the letters into a char array
			char[] tempArray = substrings.get(i).toCharArray();
			
			//sorts the array
			Arrays.sort(tempArray);
			
			String sortedString = "";
			
			//puts the letters back into a string
			for(int j = 0; j < tempArray.length; j++) {
				sortedString += tempArray[j];
			}
			
			//puts the scrambled grouping into the arraylist in the correct spot
			substrings.remove(i);
			substrings.add(i, sortedString);
		}
		
		//puts all the substrings back together
		String scrambledString = "";
		for(int i = 0; i < substrings.size(); i++) {
			scrambledString += substrings.get(i);
		}
		
		System.out.println("Your encode message is " + scrambledString);
	}
	
	public static void backwardsAlphabet(Scanner keyboard) {
		//gets the message from the user
		System.out.println("Input your message:");
		String message = keyboard.nextLine().toLowerCase();
		
		HashMap<String, String> letters = new HashMap<String, String>();
		letters.put("a", "z");
		letters.put("b", "y");
		letters.put("c", "x");
		letters.put("d", "w");
		letters.put("e", "v");
		letters.put("f", "u");
		letters.put("g", "t");
		letters.put("h", "s");
		letters.put("i", "r");
		letters.put("j", "q");
		letters.put("k", "p");
		letters.put("l", "o");
		letters.put("m", "n");
		letters.put("n", "m");
		letters.put("o", "l");
		letters.put("p", "k");
		letters.put("q", "j");
		letters.put("r", "i");
		letters.put("s", "h");
		letters.put("t", "g");
		letters.put("u", "f");
		letters.put("v", "e");
		letters.put("w", "d");
		letters.put("x", "c");
		letters.put("y", "b");
		letters.put("z", "a");
		
		String scrambledString = "";
		for(int i = 0; i < message.length(); i++) {
			if(letters.containsKey(String.valueOf(message.charAt(i)))) {
				scrambledString += letters.get(String.valueOf(message.charAt(i)));
			}
		}
		
		System.out.println("Your encoded message is " + scrambledString);
	}
	
	    public static void morseCode(Scanner keyboard)
	    {
	        
	        HashMap<String, String> morseCode = new HashMap<String, String>();
			morseCode.put("a",".-");
			morseCode.put("b","-...");
			morseCode.put("c","-.-.");
			morseCode.put("d","-..");
			morseCode.put("e",".");
			morseCode.put("f","..-.");
			morseCode.put("g","--.");
			morseCode.put("h","....");
			morseCode.put("i","..");
			morseCode.put("j",".---");
			morseCode.put("k","-.-");
			morseCode.put("l",".-..");
			morseCode.put("m","--");
			morseCode.put("n","-.");
			morseCode.put("o","---");
			morseCode.put("p",".--.");
			morseCode.put("q","..-.");
			morseCode.put("r",".-.");
			morseCode.put("s","...");
			morseCode.put("t","-");
			morseCode.put("u","..-");
			morseCode.put("v","...-");
			morseCode.put("w",".--");
			morseCode.put("x","-..-");
			morseCode.put("y","-.--");
			morseCode.put("z","--..");
			morseCode.put("1",".----");
			morseCode.put("2","..---");
			morseCode.put("3","...--");
			morseCode.put("4","....-");
			morseCode.put("5",".....");
			morseCode.put("6","-....");
			morseCode.put("7","--...");
			morseCode.put("8","---..");
			morseCode.put("9","----.");
			morseCode.put("0","-----");
			morseCode.put(",","--.--");
			morseCode.put(".",".-.-.-");
			morseCode.put("?","..--..");
			morseCode.put(" ", "/");

	        String userInput;

	        int index;

	        index = 0;

	        System.out.println(" This is an English to Morse Code Translator.  ");
	        System.out.println(" Please enter what you would like translate ");
	        System.out.println("             into Morse Code. ");
	        System.out.println(" ============================================ ");

	        userInput = keyboard.nextLine();

	        userInput = userInput.toLowerCase();
	        
	        String newmessage = "";

	        for (index = 0; index < userInput.length(); index++)           
	        {
	            newmessage += morseCode.get(String.valueOf(userInput.charAt(index)));         
	        } 
	  
	        System.out.println("Your encoded message is " + newmessage);;
	    }
}
