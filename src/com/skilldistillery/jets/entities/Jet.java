package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	private String simpleName = this.getClass().getSimpleName();

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public void fly() {
		if (simpleName.equals("RemoteControlledJet")) {
			System.out.println(simpleName + " Model: " + this.model + " is flying for "
					+ getMinutesFlying(this.speed, this.range) + " minutes");
		} else

			System.out.println(simpleName + " Model: " + this.model + " is flying for "
					+ getHoursFlying(this.speed, this.range) + " hours");
	}

	private int getHoursFlying(double speed, int range) {
		int amountOfHoursFlying = (int) (range / speed);
		return amountOfHoursFlying;
	}

	// RC Jets needed this method because their range is too low to fly for hours at
	// max speed
	private double getMinutesFlying(double speed, int range) {
		double amountOfMinutesFlying = (range / speed) * 100;
		return amountOfMinutesFlying;
	}

	@Override
	public String toString() {
		String one = simpleName + " Model: " + model + "\n";
		String two = "Speed: " + speed + "MPH \tRange: " + range + "miles \tPrice: " + price + "\n";
		return one + two;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}



}
