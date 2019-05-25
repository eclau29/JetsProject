package com.skilldistillery.projects.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
// FIELDS
	private List<Jet> jetArrList;
	private String jetsfile;

// CONSTRUCTOR
	public AirField() {
		jetsfile = "jets.txt";
		jetArrList = readJets(jetsfile);
	}

	public List<Jet> readJets(String jetsfile) { // method creates a ListArray from the txt file
		List<Jet> jetsList = new ArrayList<>(); // creating a new arrayList
		int numLines = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(jetsfile));
			String line;
			while ((line = br.readLine()) != null) {
				String[] jetsRecord = line.split(", ");
				String type = jetsRecord[0];
				String model = jetsRecord[1];
				double speed = Double.parseDouble(jetsRecord[2]);
				int range = Integer.parseInt(jetsRecord[3]);
				long price = Long.parseLong(jetsRecord[4]);
				if (jetsRecord[0].equals("Fighter")) {
					FighterJet fj = new FighterJet(type, model, speed, range, price);
					jetsList.add(fj);
				}
				if (jetsRecord[0].equals("Cargo")) {
					CargoPlane cp = new CargoPlane(type, model, speed, range, price);
					jetsList.add(cp);
				}
				if (jetsRecord[0].equals("JetLuxe")) {
					JetLuxe jluxe = new JetLuxe(type, model, speed, range, price);
					jetsList.add(jluxe);
				}
				if (jetsRecord[0].equals("Bomber")) {
					BomberJet bj = new BomberJet(type, model, speed, range, price);
					jetsList.add(bj);
				}
				if (jetsRecord[0].equals("JetImpl")) {
					JetImpl vanilli = new JetImpl(type, model, speed, range, price);
					jetsList.add(vanilli);
				}

			}
		} catch (FileNotFoundException e) { // for safety
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jetsList;
	}

	public void printJets() {
		for (Jet jet : jetArrList) {
			System.out.println(jet);
		}
	}

	public void flyAllJets() {
		for (Jet jet : jetArrList) {
			jet.fly();
		}
	}

	public void findFastestJet() {
		double fastestSpeed = 0;
		Jet fastestJet = null;
		for (Jet jet : jetArrList) {
			if (jet.getSpeed() > fastestSpeed) {
				fastestJet = jet;
				fastestSpeed = jet.getSpeed();
			}

		}
		StringBuilder fastestJetPrintout = new StringBuilder();
		fastestJetPrintout.append("The fastest jet in this airfield is the " + fastestJet.getModel());
		fastestJetPrintout.append(" with a speed of " + fastestJet.getSpeed() + " mph.\n");
		fastestJetPrintout.append("It can also fly a maximum of " + fastestJet.getRange()
				+ " miles, but you'll have to spend $" + fastestJet.getPrice() + " to get one :(");
		System.out.println(fastestJetPrintout);

	}

	public void findLongestRangeJet() {
		int longestRange = 0;
		Jet longestRangeJet = null;
		for (Jet jet : jetArrList) {
			if (jet.getRange() > longestRange) {
				longestRangeJet = jet;
				longestRange = jet.getRange();
			}
		}
		StringBuilder longestRangePrintout = new StringBuilder();
		longestRangePrintout.append("The jet with the longest range is the " + longestRangeJet.getModel());
		longestRangePrintout.append(" with a maximum range of " + longestRangeJet.getRange() + " miles.\n");
		longestRangePrintout.append("It does so with a top speed of " + longestRangeJet.getSpeed()
				+ " mph, but it'll cost you $" + longestRangeJet.getPrice() + " to get there.");
		System.out.println(longestRangePrintout);
	}

	public void loadAllCargo() {
		Jet cargoJets = null;
		for (Jet jet : jetArrList) {
			if (jet instanceof CargoCarrier || jet instanceof Reupholster) {
				cargoJets = jet;
				System.out.println(jet.getModel());
				((CargoCarrier) jet).loadCargo();
			}
		}

	}

	public void dogFight() {
		Jet fighterJets = null;
		for (Jet jet : jetArrList) {
			if (jet instanceof CombatReady || jet instanceof BombDrop) {
				fighterJets = jet;
				System.out.println(jet.getModel());
				((CombatReady) jet).fight();
			}
		}
	}

	public void reupholster() {
		Jet jetLuxe = null;
		for (Jet jet : jetArrList) {
			if (jet instanceof Reupholster) {
				jetLuxe = jet;
				System.out.println(jet.getModel());
				((Reupholster) jet).getReupholstered();
			}
		}
	}

	public void dropBombs() {
		Jet bomberJet = null;
		for (Jet jet : jetArrList) {
			if (jet instanceof BombDrop) {
				bomberJet = jet;
				System.out.println(jet.getModel());
				((BomberJet) jet).dropBombs();
			}
		}
	}

	public void addJet(Scanner kb) {
		System.out.println("What kind of jet would you like to add?\n");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Jet");
		System.out.println("3. Bomber Jet");
		System.out.println("4. Luxury Jet");
		System.out.println("5. Other");

		int addJetType = kb.nextInt();
		System.out.println("Please input some information.\n");

		System.out.print("Model: ");
		String model = kb.next();

		System.out.println("Speed (mph): ");
		double speed = kb.nextDouble();

		System.out.println("Range (mi): ");
		int range = kb.nextInt();

		System.out.println("Price (USD): ");
		long price = kb.nextLong();

		Jet newJet = null;
		
		switch (addJetType) {
		case 1:
			newJet = new FighterJet("Fighter", model, speed, range, price);
			break;
		case 2:
			newJet = new CargoPlane("Cargo", model, speed, range, price);
			break;
		case 3:
			newJet = new BomberJet("Bomber", model, speed, range, price);
			break;
		case 4:
			newJet = new JetLuxe("JetLuxe", model, speed, range, price);
			break;
		case 5:
			newJet = new JetImpl("JetImpl", model, speed, range, price);
			break;
		}
		jetArrList.add(newJet);
	}
	public void removeJet (Scanner kb) {
		System.out.println("Which jet would you like to remove?");
		for (int i = 0; i < jetArrList.size(); i++) {
			System.out.println((i+1) + ": " + jetArrList.get(i));
		} 
		int selectedJet = kb.nextInt()-1;
		System.out.println("You've chosen to remove poor ol' " + jetArrList.get(selectedJet));
		jetArrList.remove(selectedJet);
		
	}
}
