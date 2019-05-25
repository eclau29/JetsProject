package com.skilldistillery.projects.jets;

public class BomberJet extends Jet implements CargoCarrier, CombatReady, BombDrop{
private double bombWt;

	public BomberJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	public BomberJet() {
	}

	@Override
	public void fly() {
		super.fly();
		System.out.println("\tI am flying and ready to drop some DEATH upon my enemies!");
	}

	@Override
	public void fight() {
		System.out.println("\tGetting ready to fight...");
	}

	@Override
	public void loadCargo() {
		System.out.println("\tGimme that cargo full of BOB-OMBs");
	}
	@Override
	public void dropBombs() {
		System.out.println("\t!~Suelta las BOMBAS~!");		
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(bombWt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BomberJet other = (BomberJet) obj;
		if (Double.doubleToLongBits(bombWt) != Double.doubleToLongBits(other.bombWt))
			return false;
		return true;
	}

}
