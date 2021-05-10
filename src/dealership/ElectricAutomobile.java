package dealership;

public class ElectricAutomobile extends Automobile {
	private static final long serialVersionUID = 1L;
	protected int drivingRange;
	protected int batteryLife;
	
	public ElectricAutomobile() {
		super();
		drivingRange=0;
		batteryLife=0;
	}
	
	public ElectricAutomobile(
			String make,
			String model,
			int horsepower,
			int year,
			double price,
			String bodyStyle,
			int cargoCapacity,
			int drivingRange,
			int batteryLife) {
		super(make, model, horsepower, year, price, bodyStyle, cargoCapacity);
		this.drivingRange=drivingRange;
		this.batteryLife=batteryLife;
	}

	public void clear() {
		super.clear();
		drivingRange=0;
		batteryLife=0;
	}
	
	public void set(
			String make,
			String model,
			int horsepower,
			int year,
			double price,
			String bodyStyle,
			int cargoCapacity,
			int drivingRange,
			int batteryLife) {
		super.set(make, model, horsepower, year, price, bodyStyle, cargoCapacity);
		this.drivingRange=drivingRange;
		this.batteryLife=batteryLife;
	}
	
	public void print() {
		super.print();
		System.out.print(" | zasieg: " + drivingRange + " | zycie baterii: " + batteryLife);
	}
	
	public void showCurrent() {
		super.showCurrent();
		System.out.println(
			"Maksymalny zasieg: " + drivingRange
			+ "\nZywotnosc baterii: " + batteryLife
		);
	}
	
	public void setDrivingRange(int drivingRange) {
		this.drivingRange=drivingRange;
	}
	
	public void setBatteryLife(int batteryLife) {
		this.batteryLife=batteryLife;
	}
	
	public int getDrivingRange() {
		return drivingRange;
	}
	
	public int getBatteryLife() {
		return batteryLife;
	}	
}
