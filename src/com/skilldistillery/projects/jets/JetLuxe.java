package com.skilldistillery.projects.jets;

public class JetLuxe extends Jet implements CargoCarrier, Reupholster {

	public JetLuxe(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	public JetLuxe() {
	}

	@Override
	public void fly() {
		super.fly();
		System.out.println("\tI'm so fancyyy. You already know... I'm in the fast lane from LA to Tokyo. ");
	}
	

	@Override
	public void loadCargo() {
		System.out.println("\tYou better be careful with those Prada bags when you load them...");
	}

	@Override
	public void getReupholstered() {
System.out.println("\tThere's a Domaine de la Romanée-Conti Romanée-Conti Grand Cru stain on this chesterfield couch and its matching divan! We must reupholster the entire plane IMMEDIATELY.");		
	}

}
