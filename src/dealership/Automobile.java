package dealership;

public class Automobile extends Vehicle {
	private static final long serialVersionUID = 1L;
	protected String bodyStyle;
	protected int cargoCapacity;
	
	public Automobile() {
		super();
		bodyStyle="";
		cargoCapacity=0;
	}
	
	public Automobile(String make,
			String model,
			int horsepower,
			int year,
			double price,
			String bodyStyle,
			int cargoCapacity) {
		super(make, model, horsepower, year, price);
		this.bodyStyle=bodyStyle;
		this.cargoCapacity=cargoCapacity;
	}
	
	public void clear() {
		super.clear();
		bodyStyle="";
		cargoCapacity=0;
	}
	
	public void set(
			String make,
			String model,
			int horsepower,
			int year,
			double price,
			String bodyStyle,
			int cargoCapacity) {
		super.set(make, model, horsepower, year, price);
		this.bodyStyle=bodyStyle;
		this.cargoCapacity=cargoCapacity;
	}
	
	public void print() {
		super.print();
		System.out.print(" | nadwozie: " + bodyStyle + " | pojemnosc bagaznika: " + cargoCapacity);
	}
	
	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle=bodyStyle;
	}
	
	public void setCargoCapacity(int cargoCapacity) {
		this.cargoCapacity=cargoCapacity;
	}
	
	public String getBodyStyle() {
		return bodyStyle;
	}
	
	public int getCargoCapacity() {
		return cargoCapacity;
	}
}
