package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.*;

public class JetsApp {
	private Airfield airfield = new Airfield();
	private boolean quitMainMenu = false;
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.run();

	}

	public void run() {
		//greet user
		System.out.println("Welcome to the Jet App! ----\u2708");
		System.out.println();
		
		//user interacts with main menu until they quit
		do {
			mainMenu();
		} while (!quitMainMenu);

	}

	private void mainMenu() {
		//unicode for a little plane -> \u2708
		System.out.println("-----------------------------------------------");
		System.out.println("-----------------\u2708 MAIN MENU \u2708-----------------");
		System.out.println("-----------------------------------------------");
		System.out.println("------\u2708	1. List Fleet                       ---");
		System.out.println("------\u2708	2. Fly All Jets                     ---");
		System.out.println("------\u2708	3. View Fastest Jet                 ---");
		System.out.println("------\u2708	4. View Jet with Longest Range      ---");
		System.out.println("------\u2708	5. Party with Celebrities           ---");
		System.out.println("------\u2708	6. Change batteries in RC Jets      ---");
		System.out.println("------\u2708	7. Add a Jet to the Fleet           ---");
		System.out.println("------\u2708	8. Remove a Jet from the Fleet      ---");
		System.out.println("------\u2708	9. Quit                             ---");
		System.out.println("-----------------------------------------------");
		System.out.print("Choose an option (1-9): ");
		int userChoice = sc.nextInt();
		sc.nextLine();

		mainMenuSwitch(userChoice);

	}

	private void mainMenuSwitch(int userChoice) {
		switch (userChoice) {
		default:
			System.err.println("ERROR: Invalid Input. Choose an option or type 9 to quit.");
			break;
		case 1:
			// display all jets
			airfield.displayJets();
			break;
		case 2:
			// fly all jets
			airfield.flyAllJets();
			break;

		case 3:
			// view fastest jet
			airfield.findFastedJet();
			break;

		case 4:
			// view longest range
			airfield.findLongestRange();
			break;
		case 5:
			// party with celebs
			airfield.deployFancyThings();
			break;
		case 6:
			// change batteries in rc jets
			airfield.deployBatteryOperated();
			break;
		case 7:
			// add jet to fleet
			promptUserToAddJet();
			System.out.println("Jet has been added to the fleet. Happy flying ----\u2708");
			System.out.println();
			break;
		case 8:
			// remove jet from fleet
			promptUserToRemoveJet();
			System.out.println("Jet has been removed from the fleet. ----\u2708");
			System.out.println();
			break;
		case 9:
			// quit
			System.out.println("Thanks for using the Jet App. Goodbye! ----\u2708");
			quitMainMenu = true;
			break;

		}

	}

	private void promptUserToAddJet() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Add a New Jet----\u2708   ");
		System.out.println("---------------------------------");
		System.out.print("Enter the jet's model: ");
		String model = sc.nextLine();
		System.out.print("Enter the jet's speed (in MPH): ");
		double speed = sc.nextDouble();
		sc.nextLine(); // flush
		System.out.print("Enter the jet's range: ");
		int range = sc.nextInt();
		sc.nextLine(); // flush
		System.out.print("Enter the jet's purchase price: ");
		long purchasePrice = sc.nextLong();
		sc.nextLine(); // flush

		airfield.addJet(model, speed, range, purchasePrice);

	}

	private void promptUserToRemoveJet() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println("----Remove a Jet----\u2708    ");
		System.out.println("---------------------------------");
		// new display including index number so users have a numbered option to select
		airfield.removeJetDisplay();
		System.out.println("Which jet would you like to remove?");

		int userChoice = sc.nextInt();
		sc.nextLine(); // flush

		airfield.removeJet(userChoice);
	}

}
