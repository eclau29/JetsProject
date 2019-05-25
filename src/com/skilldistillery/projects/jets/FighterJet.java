package com.skilldistillery.projects.jets;

public class FighterJet extends Jet implements CombatReady{
// INHERITS FIELDS
	
	public FighterJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	public FighterJet() {
	}

@Override
public void fight() {
	System.out.println("\tIMMA KILL YOU WITH MY ARMAMENT *PEW PEW* *POW POW*");
}

@Override
public void fly() {
	super.fly();
	System.out.println("\t...aaand TAKEOFF!");
	// TODO Auto-generated method stub
	
}
}
