package com.skilldistillery.jets.entities;

public class PrivateJet extends Jet implements FancyThings {

	public PrivateJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCelebrities() {
		System.out.println("Loading celebrities onto private jet " + this.getModel() + "...");
	}

	@Override
	public void popChampagne() {
		System.out.println("Popping champagne. Cheers!");		
	}



}
