package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private List<Jet> fleet = new ArrayList<>();

	public Airfield() {
		readJets();

	}

	private void readJets() {

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] split = line.split(",");
				String typeOfJet = split[0];
				String model = split[1];
				double speed = Double.parseDouble(split[2]);
				int range = Integer.parseInt(split[3]);
				long price = Long.parseLong(split[4]);
				Jet jet = null;

				switch (typeOfJet) {
				case "PassengerJet":
					jet = new PassengerJet(model, speed, range, price);
					break;
				case "PrivateJet":
					jet = new PrivateJet(model, speed, range, price);
					break;
				case "RemoteControlledJet":
					jet = new RemoteControlledJet(model, speed, range, price);
					break;
				}

				fleet.add(jet);

			}
		}

		catch (IOException e) {
			System.err.println(e);
		}
	}

	public void displayJets() {
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
	}

	public void flyAllJets() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	public void findFastedJet() {
		double fastestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : fleet) {
			if (fastestSpeed < jet.getSpeed()) {
				fastestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		System.out.println("The fastest jet is: " + fastestJet.getModel() + " traveling " + fastestJet.getSpeed() + "MPH");
	}
	
	public void findLongestRange() {
		int longestRange = 0;
		Jet longestRangeJet = null;
		for (Jet jet : fleet) {
			if ( longestRange < jet.getRange()) {
				longestRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		System.out.println("The jet with the longest range is : " + longestRangeJet.getModel() + " traveling " + longestRangeJet.getRange() + " miles");
	}
}
