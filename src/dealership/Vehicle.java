package dealership;

import java.io.Serializable;

public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String make;
	protected String model;
	protected int horsepower;
	protected int year;
	protected double price;
	
	public Vehicle() {
		make="";
		model="";
		horsepower=0;
		year=0;
		price=0;
	}
	
	public Vehicle(String make, String model, int horsepower, int year, double price) {
		this.make=make;
		this.model=model;
		this.horsepower=horsepower;
		this.year=year;
		this.price=price;
	}
	
	public void clear() {
		make="";
		model="";
		horsepower=0;
		year=0;
		price=0;
	}
	
	public void set(String make, String model, int horsepower, int year, double price) {
		this.make=make;
		this.model=model;
		this.horsepower=horsepower;
		this.year=year;
		this.price=price;
	}
	
	public void print() {
		System.out.print(
			"Marka: " + make + " | model: " + model + " | KM: " + horsepower + " | rok: " + year + " | cena: " + price
		);
	}
	
	public void setMake(String make) {
		this.make=make;
	}
	
	public void setModel(String model) {
		this.model=model;
	}
	
	public void setHorsepower(int horsepower) {
		this.horsepower=horsepower;
	}
	
	public void setYear(int year) {
		this.year=year;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getHorsepower() {
		return horsepower;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getPrice() {
		return price;
	}
}
