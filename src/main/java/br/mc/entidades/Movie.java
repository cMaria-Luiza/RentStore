package br.mc.entidades;

public class Movie {

	private int units;
	private int price;
	private int daysToReturn = 1;

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDaysToReturn() {
		return daysToReturn;
	}

	public void setDaysToReturn(int daysToReturn) {
		this.daysToReturn = daysToReturn;
	}

}
