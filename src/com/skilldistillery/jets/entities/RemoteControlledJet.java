package com.skilldistillery.jets.entities;

public class RemoteControlledJet extends Jet implements BatteryOperated {

	public RemoteControlledJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void changeBatteries() {
		System.out.println("Changing batteries in RC jet " + this.getModel() + "...");
		System.out.println("Ready for takeoff!");
		
	}



}
