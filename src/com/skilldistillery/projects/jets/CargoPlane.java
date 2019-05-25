package com.skilldistillery.projects.jets;

public class CargoPlane extends Jet implements CargoCarrier {
// INHERITS JET FIELDS
	
// CONSTRUCTORS

	public CargoPlane (String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	public CargoPlane() {
	}
	

	
	@Override
	public void fly() {
		super.fly();
System.out.println("\t*rmblrmblrmbl* I've got a belly full of cargo so now I'm taking off! *wooooooosssSSSHHHH* ");	
	}
	
	public void loadCargo() {
		System.out.println("\tGIMME THAT CARGO");
	}

}
