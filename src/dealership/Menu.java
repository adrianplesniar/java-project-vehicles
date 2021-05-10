package dealership;

import java.util.Scanner;

public class Menu {
	private static Scanner scanner = new Scanner(System.in);
	static String make, model, bodyStyle, type, isStreetLegal;
	static int horsepower, year, cargoCapacity, drivingRange, batteryLife;
	static double price, fuelEconomy, engineCapacity;
	static int size;
	static Fleet fleet = new Fleet();

	public static void main(String[] args) {
		System.out.println("Wprowadz maksymaln¹ iloœæ pojazdów: ");
		size = scanner.nextInt();
		fleet = new Fleet(size);
		
		char ch = ' ';
    	while (ch != 'X' || ch !='x')
    	{
	      	mainMenu();
	    	ch = select();
	    	output(ch);
    	}
	}
	
	public static void mainMenu() {
		System.out.println("MENU");
		System.out.println("----\n");
		System.out.println("0 - Nowa baza");
		System.out.println("1 - Dodaj pojazd");
		System.out.println("2 - Wyswietl wszystkie");
		System.out.println("3 - Zapisz do pliku");
		System.out.println("4 - Odczyt z pliku");
	}
	
	public static void vehicleMenu() {
		System.out.println("Wybierz rodzaj pojazdu");
		System.out.println("----------------------\n");
		System.out.println("0 - Samochód spalinowy");
		System.out.println("1 - Samochód elektryczny");
		System.out.println("2 - Motocykl");
	}
	
	public static char select() {
	System.out.print ("Wybierz: ");
	String ch = scanner.next();
	char selected = ' ';
	if( ch.length() > 0 )
		selected = ch.charAt(0);
	
	return selected;
    }
	
	public static void output(char ch) {
	switch (ch) {
	case '0':
		fleet.clearAll();
		System.out.println("Wprowadz maksymaln¹ iloœæ pojazdów: ");
		size = scanner.nextInt();
		fleet = new Fleet(size);
		break;
	case '1':
		vehicleMenu();
		ch = select();
		switch(ch) {
		case '0':
			System.out.println("Marka: ");
			make = scanner.next();
			System.out.println("Model: ");
			model = scanner.next();
			System.out.println("Moc: ");
			horsepower = scanner.nextInt();
			System.out.println("Rok produkcji: ");
			year = scanner.nextInt();
			System.out.println("Cena: ");
			price = scanner.nextDouble();
			System.out.println("Nadwozie: ");
			bodyStyle = scanner.next();
			System.out.println("Pojemnoœæ baga¿nika: ");
			cargoCapacity = scanner.nextInt();
			System.out.println("Pojemnoœæ silnika: ");
			engineCapacity = scanner.nextDouble();
			System.out.println("Spalanie: ");
			fuelEconomy = scanner.nextDouble();
			fleet.addVehicle(new GasAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, engineCapacity, fuelEconomy));
			break;
		case '1':
			System.out.println("Marka: ");
			make = scanner.next();
			System.out.println("Model: ");
			model = scanner.next();
			System.out.println("Moc: ");
			horsepower = scanner.nextInt();
			System.out.println("Rok produkcji: ");
			year = scanner.nextInt();
			System.out.println("Cena: ");
			price = scanner.nextDouble();
			System.out.println("Nadwozie: ");
			bodyStyle = scanner.next();
			System.out.println("Pojemnoœæ baga¿nika: ");
			cargoCapacity = scanner.nextInt();
			System.out.println("Zasiêg: ");
			drivingRange = scanner.nextInt();
			System.out.println("¯ycie baterii: ");
			batteryLife = scanner.nextInt();
			fleet.addVehicle(new ElectricAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, drivingRange, batteryLife));
			break;
		case '2':
			System.out.println("Marka: ");
			make = scanner.next();
			System.out.println("Model: ");
			model = scanner.next();
			System.out.println("Moc: ");
			horsepower = scanner.nextInt();
			System.out.println("Rok produkcji: ");
			year = scanner.nextInt();
			System.out.println("Cena: ");
			price = scanner.nextDouble();
			System.out.println("Rodzaj: ");
			type = scanner.next();
			System.out.println("Homologacja: ");
			isStreetLegal = scanner.next();
			fleet.addVehicle(new Motorcycle(make, model, horsepower, year, price, type, isStreetLegal));
			break;
		}
		
		break;
	case '2':
		fleet.printFleet();
		System.out.println(fleet.getSize());
		break;
	case '3':
		fleet.saveFile();
		break;
	case '4':
		fleet.readFile();
		break;
        }
    }

}
