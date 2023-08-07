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
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Display Fleet----\u2708   ");
		System.out.println("---------------------------------");
		for (Jet jet : fleet) {
			System.out.println(jet);
		}
	}

	public void flyAllJets() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Flying All Jets----\u2708 ");
		System.out.println("---------------------------------");
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	public void findFastedJet() {

		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Fastest Jet----\u2708");
		System.out.println("---------------------------------");
		double fastestSpeed = 0.0;
		Jet fastestJet = null;
		for (Jet jet : fleet) {
			if (fastestSpeed < jet.getSpeed()) {
				fastestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		System.out.println("The fastest jet is: " + fastestJet.getSimpleName() + " " + fastestJet.getModel()
				+ " traveling " + fastestJet.getSpeed() + "MPH");
	}

	public void findLongestRange() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Longest Range----\u2708");
		System.out.println("---------------------------------");
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
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Party with Celebrities----\u2708");
		System.out.println("---------------------------------");
		for (Jet jet : fleet) {
			if (jet instanceof PrivateJet) {
				// do fancy things
				((PrivateJet) jet).clientele();
				((PrivateJet) jet).service();
			}
		}

	}

	public void deployBatteryOperated() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Change Batteries----\u2708");
		System.out.println("---------------------------------");
		for (Jet jet : fleet) {
			if (jet instanceof RemoteControlledJet) {
				// do battery operated things
				((RemoteControlledJet) jet).changeBatteries();
			}
		}
	}

	public void addJet(int userChoice, String model, double speed, int range, long purchasePrice) {
		if (userChoice == 1) {
			Jet newPassengerJet = new PassengerJet(model, speed, range, purchasePrice);
			fleet.add(newPassengerJet);
			System.out.println("Jet has been added to the fleet. Happy flying ----\u2708");

		} else if (userChoice == 2) {
			Jet newPrivateJet = new PrivateJet(model, speed, range, purchasePrice);
			fleet.add(newPrivateJet);
			System.out.println("Jet has been added to the fleet. Happy flying ----\u2708");

		} else if (userChoice == 3) {
			Jet newRCJet = new RemoteControlledJet(model, speed, range, purchasePrice);
			fleet.add(newRCJet);
			System.out.println("Jet has been added to the fleet. Happy flying ----\u2708");

		} else {
			System.err.println("Invalid Jet Type. Please try again.");
		}

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
