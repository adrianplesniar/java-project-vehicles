package dealership;

public class GasAutomobile extends Automobile {
	private static final long serialVersionUID = 1L;
	protected double engineCapacity;
	protected double fuelEconomy;
	
	public GasAutomobile() {
		super();
		engineCapacity=0;
		fuelEconomy=0;
	}
	
	public GasAutomobile(
			String make,
			String model,
			int horsepower,
			int year,
			double price,
			String bodyStyle,
			int cargoCapacity,
			double engineCapacity,
			double fuelEconomy) {
		super(make, model, horsepower, year, price, bodyStyle, cargoCapacity);
		this.engineCapacity=engineCapacity;
		this.fuelEconomy=fuelEconomy;
	}
	
	public GasAutomobile(GasAutomobile v) {
		super(v);
		engineCapacity = v.engineCapacity;
		fuelEconomy = v.fuelEconomy;
	}
	
	public void clear() {
		super.clear();
		engineCapacity=0;
		fuelEconomy=0;
	}
	
	public void set(
			String make,
			String model,
			int horsepower,
			int year,
			double price,
			String bodyStyle,
			int cargoCapacity,
			double engineCapacity,
			double fuelEconomy) {
		super.set(make, model, horsepower, year, price, bodyStyle, cargoCapacity);
		this.engineCapacity=engineCapacity;
		this.fuelEconomy=fuelEconomy;
	}
	
	public void print() {
		super.print();
		System.out.print(" | pojemnosc silnika: " + engineCapacity + " | spalanie: " + fuelEconomy);
	}
	
	public void showCurrent() {
		super.showCurrent();
		System.out.println(
			"Pojemnoœæ silnika: " + engineCapacity
			+ "\nŒrednie spalanie: " + fuelEconomy	
		);
	}
	
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity=engineCapacity;
	}
	
	public void setFuelEconomy(double fuelEconomy) {
		this.fuelEconomy=fuelEconomy;
	}
	
	public double getEngineCapacity() {
		return engineCapacity;
	}
	
	public double getFuelEconomy() {
		return fuelEconomy;
	}
}
