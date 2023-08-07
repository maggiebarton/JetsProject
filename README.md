# JetsProject
## Overview
Welcome to the Jet App! Users can interact with jets with different capabilities. Five jets are loaded into the fleet at the start of the application. Jets in this application are one of the following types:

1. Passenger Jet
2. Private Jet
3. Remote Controlled Jet

From the main menu, users can view the fleet of jets including specific details for each, fly all the jets (based on each jet's speed and range), find the fastest jet and jet with the longest range in the fleet, as well as access specialized behavior for Private Jets and Remote Controlled Jets.

Users also have the ability to add and remove jets from the fleet. Any jet added is present in the fleet while the application is running. Users can cycle through the Main Menu as long as they wish, until they choose option '9' to quit the application. Happy flying!

## Lessons Learned
While working on this project, the four pillars of OOP were very apparent to me.

Using the Airfield to "house" the fleet of jets, as well as all the methods used in the Main Menu, created a way hide the actual implementation of the code from the user while interacting with the Jet App. The only methods present in the JetsApp contain interaction with the user; taking data input from the user and sending it over to the Airfield, then having the Airfield send back an appropriate method based on what the user is asking. The only entity the JetsApp needed to be aware of was the Airfield. To ensure proper treatment of this data and function of methods, I paid very close attention to the visibility of every field and method. The data and methods are "wrapped up" together in a single Object, JetsApp. Abstraction! Encapsulation!

Using Interfaces created specialized behavior for different types of jets. Although I only have one specific type of jet using each of the two Interfaces, I could easily add new types of jets that might have the same specialized behavior but executed in a different way (i.e. a BusinessJet that extends Jet and implements FancyThings).

The way PrivateJet executes methods in FancyThings:


	@Override
	public void clientele() {
		System.out.println("Loading celebrities onto private jet " + this.getModel() + "...");
	}

	@Override
	public void service() {
		System.out.println("Popping champagne. Cheers!");
	}

Versus how BusinessJet might execute methods in FancyThings:

	@Override
	public void clientele() {
		System.out.println("Loading businessmen onto business jet " + this.getModel() + "...");
	}

	@Override
	public void service() {
		System.out.println("Serving breakfast and pouring coffee.");
	}
	
Moreover, having one List containing all jets in the fleet, regardless of what type of jet it is, created a specific routine to search for and execute these specialized behaviors. If a particular jet on the List is an *instaceof* PrivateJet, do FancyThings. Polymorphism!

PassengerJet, PrivateJet and RemoteControlledJet are all child classes of Jet. Every Jet can fly, so the method to fly lives in the Jet Class and is used by the child classes. Inheritance!


## Technologies Used
- Java
- Eclipse
- Git
- GitHub