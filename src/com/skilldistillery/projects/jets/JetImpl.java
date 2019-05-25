package com.skilldistillery.projects.jets;

public class JetImpl extends Jet {

	// FIELDS INHERITED

	// CONSTRUCTOR

	public JetImpl(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	public JetImpl() {
	}

	// METHODS
	@Override
	public void fly() {
		super.fly();
		System.out.println("\tI'm going to take off...but only when I'm ready.");
	}

}
