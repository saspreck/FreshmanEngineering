package enigma;

import java.util.Scanner;

	public class Base {

		public static void enigmaRun() {
	
			String type;
			char rotor1;
			char rotor2;
			char rotor3;
			String input = "";
			
			Plugboard plugboard = new Plugboard();
	
			Scanner scnr = new Scanner(System.in);
	
			System.out.println("Please enter the type of enigma you want to use, Commercial or Swiss.");
			
			type = scnr.next();
			
			if (type.equalsIgnoreCase("commercial")) {
				System.out.println("Please enter the first rotor, do not repeat rotors.");
				System.out.println("A. IC");
				System.out.println("B. IIC");
				System.out.println("C. IIIC");
				
				rotor1 = scnr.next().charAt(0);
				scnr.nextLine();
				
				System.out.println("Please enter the second rotor, do not repeat rotors.");
				System.out.println("A. IC");
				System.out.println("B. IIC");
				System.out.println("C. IIIC");
				
				rotor2 = scnr.next().charAt(0);
				scnr.nextLine();
				
				System.out.println("Please enter the third rotor, do not repeat rotors.");
				System.out.println("A. IC");
				System.out.println("B. IIC");
				System.out.println("C. IIIC");
				
				rotor3 = scnr.next().charAt(0);
				scnr.nextLine();
			}
			
			else {
				System.out.println("Please enter the first rotor, do not repeat rotors.");
				System.out.println("A. I-K");
				System.out.println("B. II-K");
				System.out.println("C. III-K");
				
				rotor1 = scnr.next().charAt(0);
				scnr.nextLine();
				
				System.out.println("Please enter the second rotor, do not repeat rotors.");
				System.out.println("A. I-K");
				System.out.println("B. II-K");
				System.out.println("C. III-K");
				
				rotor2 = scnr.next().charAt(0);
				scnr.nextLine();
				
				System.out.println("Please enter the third rotor, do not repeat rotors.");
				System.out.println("A. I-K");
				System.out.println("B. II-K");
				System.out.println("C. III-K");
				
				rotor3 = scnr.next().charAt(0);
				scnr.nextLine();
			}
			Rotors main = new Rotors(rotor1, rotor2, rotor3, type);
			int tempVal;
			char val1;
			char val2;
			tempVal = 0;
			while (!(tempVal == 6)) {
				
				System.out.println("Please enter an action. Ex. Enter 3 to set rotor positions.");
				System.out.println("1. Add a plugboard");
				System.out.println("2. Remove a plugboard");
				System.out.println("3. Set rotor positions");
				System.out.println("4. Encode Message.");
				System.out.println("5. Decode Message.");
				System.out.println("6. Quit");
				
				tempVal = scnr.nextInt();
				scnr.nextLine();
				
				if (tempVal == 1) {
					System.out.println("Please enter the first letter to be swapped.");
					val1 = scnr.next().charAt(0);
					System.out.print("Please enter the second letter to be swapped.");
					val2 = scnr.next().charAt(0);
					plugboard.addPlugs(String.valueOf(val1), String.valueOf(val2));
					System.out.println("Plugs added!");
				}
				else if (tempVal == 2) {
					
				}
				else if (tempVal == 3) {
					System.out.println("Please enter the number of the first position.");
					int A = scnr.nextInt();
					System.out.println("Please enter the number of the second position.");
					int B = scnr.nextInt();
					System.out.println("Please enter the number of the third position.");
					int C = scnr.nextInt();
					main.setRotorPositions(A, B, C);
					System.out.println("Rotors set!");
				}
				else if (tempVal == 4) {
					System.out.println("Please enter your message to be encrypted.");
					String message = scnr.nextLine();
					System.out.println(main.encryptMessage(message));
				}
				else {
					
				}
			}
								
		}

	}
