package com.skilldistillery.projects.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		Scanner kb = new Scanner(System.in);

		jetsApp.run(kb);

		kb.close();
	}

	
	

	private void run(Scanner kb) {
		menu(kb);

	}

	public void menu(Scanner kb) {
		AirField airField = new AirField(); // creates new airfield with the jet Array List derived from txt file.
		boolean cont = true;
		System.out.println("Welcome to JetSPLOSION, a Jet Simulator.\nPlease select a number option below:");
		while (cont) {
			System.out.println();
			System.out.println(" 1. List The Fleet");
			System.out.println(" 2. Fly All Jets");
			System.out.println(" 3. View Fastest Jet");
			System.out.println(" 4. View Jet with Longest Range");
			System.out.println(" 5. Load all Cargo Jets");
			System.out.println(" 6. Dogfight!");
			System.out.println(" 7. ReUpholster the Luxury Jets");
			System.out.println(" 8. Drop Bombs");
			System.out.println(" 9. Add a Jet to The Fleet");
			System.out.println("10. Remove a Jet from The Fleet");
			System.out.println("11. Quit");

			int selection = kb.nextInt();
			
			switch (selection) {
			case 1:
				System.out.println("\nYou've chosen to list all jets in the fleet.\n");
				airField.printJets();
				break;
			case 2:
				System.out.println("\nYou've chosen to fly all the jets at once.\n");
				airField.flyAllJets();
				break;
			case 3:
				airField.findFastestJet();
				break;
			case 4:
				airField.findLongestRangeJet();
				break;
			case 5:
				System.out.println("\nLet's load these jets!\n");
				airField.loadAllCargo();
				break;
			case 6:
				System.out.println("\nDOOOOOOOGFIIIIIGHT\n");
				airField.dogFight();
				break;
			case 7:
				System.out.println("\nYou chose to reupholster the luxury jets.");
				airField.reupholster();
				break;
			case 8:
				System.out.println(
						"\nYou chose to drop bombs everywhere, causing millions of damage and killing countless lives.");
				airField.dropBombs();
				break;
			case 9:
				System.out.println("\nLet's add a jet!\n");
				 airField.addJet(kb);
				break;
			case 10:
				System.out.println("\nLet's forcibly retire a jet!\n");
				 airField.removeJet(kb);
				break;
			case 11:
				System.out.println("\nYou've chosen to exit. *wompwomp*\n");
				System.exit(0);
				break;
			}
			System.out.println("\nWould you like to do something else? (Y/N)");
			String answer = kb.next();
			if (answer.equalsIgnoreCase("Y")) {
			} 
			else if (answer.equalsIgnoreCase("N")) {
				System.out.println("You've chosen to leave JetSPLOSION! Your friendly neighborhood Jet Simulator. Hope to see you soon! :D");
				cont = false;
				
			} else {
				System.out.println("Invalid Entry. Restarting JETSPLOSION.");
			}
		}

	}

}