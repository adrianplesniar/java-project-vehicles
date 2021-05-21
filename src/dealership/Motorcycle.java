package dealership;

public class Motorcycle extends Vehicle {
	private static final long serialVersionUID = 1L;
	protected String type;
	protected String isStreetLegal;
	
	public Motorcycle() {
		super();
		type="";
		isStreetLegal="";
	}
	
	public Motorcycle(
			String make,
			String model,
			int horsepower,
			int year,
			double price,
			String type,
			String isStreetLegal) {
		super(make, model, horsepower, year, price);
		this.type=type;
		this.isStreetLegal=isStreetLegal;
	}
	
	//copy constructor
	
	public Motorcycle(Motorcycle v) {
		super(v);
		type = v.type;
		isStreetLegal = v.isStreetLegal;
	}
	
	public void clear() {
		super.clear();
		type="";
		isStreetLegal="";
	}
	
	public void set(
			String make,
			String model,
			int horsepower,
			int year,
			double price,
			String type,
			String isStreetLegal) {
		super.set(make, model, horsepower, year, price);
		this.type=type;
		this.isStreetLegal=isStreetLegal;
	}
	
	public void print() {
		super.print();
		System.out.print(" | typ: " + type + " | homologacja: " + isStreetLegal);
	}
	
	public void showCurrent() {
		super.showCurrent();
		System.out.println(
			"Rodzaj motocykla: " + type
			+ "\nHomologacja: " + isStreetLegal	
		);
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public void setIsStreetLegal(String isStreetLegal) {
		this.isStreetLegal=isStreetLegal;
	}
	
	public String getType() {
		return type;
	}
	
	public String getIsStreetLegal() {
		return isStreetLegal;
	}
}
