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

		do {
			mainMenu();
		} while (!quitMainMenu);

	}

	private void mainMenu() {
		System.out.println("1. List Fleet");
		System.out.println("2. Fly All Jets");
		System.out.println("3. View Fastest Jet");
		System.out.println("4. View Jet with Longest Range");
		System.out.println("5. Party with Celebrities");
		System.out.println("6. Change batteries in RC Jets");
		System.out.println("7. Add a Jet to the Fleet");
		System.out.println("8. Remove a Jet from the Fleet");
		System.out.println("9. Quit");
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
			System.out.println("Your jet has been added to the fleet.");
			break;
		case 8:
			// remove jet from fleet
			promptUserToRemoveJet();
			break;
		case 9:
			// quit
			System.out.println("Thanks for using the Jet App. Goodbye!");
			quitMainMenu = true;
			break;

		}

	}
	
	private void promptUserToAddJet() {
		System.out.print("Enter the jet's model: ");
		String model = sc.nextLine();
		System.out.print("Enter the jet's speed (in MPH): ");
		double speed = sc.nextDouble();
		sc.nextLine(); //flush
		System.out.print("Enter the jet's range: ");
		int range = sc.nextInt();
		sc.nextLine(); //flush
		System.out.print("Enter the jet's purchase price: ");
		long purchasePrice = sc.nextLong();
		sc.nextLine(); //flush
		
		
		airfield.addJet(model, speed, range, purchasePrice);
		
	}
	
	public void promptUserToRemoveJet() {
		System.out.println("Which jet would you like to remove?");
	}
	

}
