package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private List<Jet> fleet = new ArrayList<>();
	private String fileName = "jets.txt";

	public Airfield() {
		readJets(fileName);

	}

	private void readJets(String fileName) {

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
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
		System.out.println(
				"The fastest jet is: " + fastestJet.getModel() + " traveling " + fastestJet.getSpeed() + "MPH");
	}

	public void findLongestRange() {
		int longestRange = 0;
		Jet longestRangeJet = null;
		for (Jet jet : fleet) {
			if (longestRange < jet.getRange()) {
				longestRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		System.out.println("The jet with the longest range is : " + longestRangeJet.getModel() + " traveling "
				+ longestRangeJet.getRange() + " miles");
	}

	public void deployFancyThings() {
		for (Jet jet : fleet) {
			if (jet instanceof PrivateJet) {
				//do fancy things
				((PrivateJet) jet).loadCelebrities();
				((PrivateJet) jet).popChampagne();
			}
		}
		
	}
	
	public void deployBatteryOperated() {
		for (Jet jet : fleet) {
			if (jet instanceof RemoteControlledJet) {
				//do battery operated things
				((RemoteControlledJet) jet).changeBatteries();
			}
		}
	}
	
	public void addJet (String model, double speed, int range, long purchasePrice) {
		Jet newJet = new PassengerJet(model, speed, range, purchasePrice);
		fleet.add(newJet);
		
	}
	
	public void removeJetDisplay() {
		for (int i = 0; i <= fleet.size() - 1; i++) {
			System.out.println("Choose option '" + i + "' to remove:");
			System.out.println(fleet.get(i));
		}
		
	}
	
	public void removeJet(int i) {
		fleet.remove(i);
	}
	

}
