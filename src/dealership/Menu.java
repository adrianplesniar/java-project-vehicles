package dealership;

import java.util.Locale;
import java.util.Scanner;

public class Menu {
	private static Scanner scanner = new Scanner(System.in);
	static String make, model, bodyStyle, type, isStreetLegal;
	static int horsepower, year, cargoCapacity, drivingRange, batteryLife, min, max;
	static double price, fuelEconomy, engineCapacity;
	static int size, index;
	static Fleet fleet = new Fleet();

	public static void main(String[] args) {
		scanner.useLocale(Locale.US);
		System.out.print("Wprowadz maksymaln¹ iloœæ pojazdów: ");
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
		System.out.println("\n\nMENU");
		System.out.println("----\n");
		System.out.println("0 - Nowa baza");
		System.out.println("1 - Dodaj pojazd");
		System.out.println("2 - Wyswietl wszystkie");
		System.out.println("3 - Zapisz do pliku");
		System.out.println("4 - Odczyt z pliku");
		System.out.println("5 - Wyswietl bierz¹cy");
		System.out.println("6 - Ustaw bierz¹cy");
		System.out.println("7 - Znajdz pojazdy mieszcz¹ce siê w podanym przedziale cenowym");
	}
	
	public static void vehicleMenu() {
		System.out.println("\n\nWybierz rodzaj pojazdu");
		System.out.println("----------------------\n");
		System.out.println("0 - Samochód spalinowy");
		System.out.println("1 - Samochód elektryczny");
		System.out.println("2 - Motocykl");
		System.out.println("x - Powrót do MENU");
	}
	
	public static void showCurrentMenu() {
		System.out.println("\n\n------------------");
		System.out.println("Przegladaj pojazdy");
		System.out.println(". - Nastepny");
		System.out.println(", - Poprzedni");
		System.out.println("d - Usuñ bierzêcy");
		System.out.println("x - Powrót do MENU");
	}
	
	public static void showCurrentFoundPriceMenu() {
		System.out.println("\n\n------------------");
		System.out.println("Przegladaj pojazdy z podanego przedzia³u cenowego");
		System.out.println(". - Nastepny znaleziony");
		System.out.println(", - Poprzedni znaleziony");
		System.out.println("x - Powrót do MENU");
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
			System.out.print("Wprowadz maksymaln¹ iloœæ pojazdów: ");
			size = scanner.nextInt();
			fleet = new Fleet(size);
			break;
		case '1':
			vehicleMenu();
			ch = select();
			switch(ch) {
			case '0':
				System.out.print("Marka: ");
				make = scanner.next();
				System.out.print("Model: ");
				model = scanner.next();
				boolean valid = false;
				do {
					System.out.print("Moc silnika: ");
					if(scanner.hasNextInt()) {
						horsepower = scanner.nextInt();
						if(horsepower>0)
							valid = true;
						else
							System.out.println("Podano b³êdn¹ wartoœæ");
					} else {
						System.out.println("Podano b³êdn¹ wartoœæ");
						scanner.next();
					}	
				}while(valid == false);
				valid = false;
				do {
					System.out.print("Rok produkcji: ");
					if(scanner.hasNextInt()) {
						year = scanner.nextInt();
						if(year>0)
							valid = true;
						else
							System.out.println("Podano b³êdn¹ wartoœæ");
					} else {
						System.out.println("Podano b³êdn¹ wartoœæ");
						scanner.next();
					}	
				}while(valid == false);
				valid = false;
				do {
					System.out.print("Cena: ");
					if(scanner.hasNextDouble()) {
						price = scanner.nextDouble();
						if(price>0)
							valid = true;
						else
							System.out.println("Podano b³êdn¹ wartoœæ");
					} else {
						System.out.println("Podano b³êdn¹ wartoœæ");
						scanner.next();
					}	
				}while(valid == false);
				System.out.print("Nadwozie: ");
				bodyStyle = scanner.next();
				valid = false;
				do {
					System.out.print("Pojemnoœæ baga¿nika: ");
					if(scanner.hasNextInt()) {
						cargoCapacity = scanner.nextInt();
						if(cargoCapacity>0)
							valid = true;
						else
							System.out.println("Podano b³êdn¹ wartoœæ");
					} else {
						System.out.println("Podano b³êdn¹ wartoœæ");
						scanner.next();
					}	
				}while(valid == false);
				System.out.print("Pojemnoœæ silnika: ");
				engineCapacity = scanner.nextDouble();
				System.out.print("Spalanie: ");
				fuelEconomy = scanner.nextDouble();
				fleet.addVehicle(new GasAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, engineCapacity, fuelEconomy));
				break;
			case '1':
				System.out.print("Marka: ");
				make = scanner.next();
				System.out.print("Model: ");
				model = scanner.next();
				System.out.print("Moc: ");
				horsepower = scanner.nextInt();
				System.out.print("Rok produkcji: ");
				year = scanner.nextInt();
				System.out.print("Cena: ");
				price = scanner.nextDouble();
				System.out.print("Nadwozie: ");
				bodyStyle = scanner.next();
				System.out.print("Pojemnoœæ baga¿nika: ");
				cargoCapacity = scanner.nextInt();
				System.out.print("Zasiêg: ");
				drivingRange = scanner.nextInt();
				System.out.print("¯ycie baterii: ");
				batteryLife = scanner.nextInt();
				fleet.addVehicle(new ElectricAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, drivingRange, batteryLife));
				break;
			case '2':
				System.out.print("Marka: ");
				make = scanner.next();
				System.out.print("Model: ");
				model = scanner.next();
				System.out.print("Moc: ");
				horsepower = scanner.nextInt();
				System.out.print("Rok produkcji: ");
				year = scanner.nextInt();
				System.out.print("Cena: ");
				price = scanner.nextDouble();
				System.out.print("Rodzaj: ");
				type = scanner.next();
				System.out.print("Homologacja: ");
				isStreetLegal = scanner.next();
				fleet.addVehicle(new Motorcycle(make, model, horsepower, year, price, type, isStreetLegal));
				break;
			case 'x':
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
		case '5':
			boolean currentMenu = true;
			while (currentMenu) {
				fleet.showCurrent();
				showCurrentMenu();
				ch = select();
				switch(ch) {
					case '.':
						fleet.next();
						fleet.showCurrent();
						break;
					case ',':
						fleet.previous();
						fleet.showCurrent();
						break;
					case 'd':
						System.out.println("Czy na pewno chcesz usun¹æ bierz¹cy element? t = tak");
						String deleteCurrent = scanner.next();
						if(deleteCurrent.charAt(0) == 't') {
							fleet.deleteCurrent();
							System.out.println("Usuniêto bierz¹cy");
						} else {
							System.out.println("Pojazd nie zosta³ usuniêty");
						}
						fleet.showCurrent();
						break;
					case 'x':
						currentMenu = false;
				}
			}
			break;
		case '6':
			System.out.print("Podaj wartoœæ indeksu: ");
			index = scanner.nextInt();
			int maxIndex = fleet.getQuantity()-1;
			if(fleet.setCurrent(index)) {
				System.out.println("Wprowadzono b³êdnœ wartoœæ! Podaj wartoæœ z przedzia³u <0," + maxIndex + ">.");
			} else {
				fleet.setCurrent(index);
			}
			break;
		case '7':
			boolean valid = false;
			do {
				System.out.println("Podaj cene min: ");
				if(scanner.hasNextInt()) {
					min = scanner.nextInt();
					if(min>=0)
						valid = true;
					else
						System.out.println("Podano b³êdn¹ wartoœæ");
				} else {
					System.out.println("Podano b³êdn¹ wartoœæ");
					scanner.next();
				}	
			}while(valid == false);
			valid = false;
			do {
				System.out.println("Podaj cene max: ");
				if(scanner.hasNextInt()) {
					max = scanner.nextInt();
					if(max>=0 && max>=min)
						valid = true;
					else
						System.out.println("Podano b³êdn¹ wartoœæ");
				} else {
					System.out.println("Podano b³êdn¹ wartoœæ");
					scanner.next();
				}	
			}while(valid == false);
			if(!fleet.searchPrice(min, max))
				System.out.println("Nic nie znaleziono.");
			else 
				fleet.showCurrentFoundPrice();
			boolean foundPriceMenu = true;
			while(foundPriceMenu) {
				showCurrentFoundPriceMenu();
				ch = select();
				switch(ch) {
					case '.':
						fleet.nextFoundPrice();
						fleet.showCurrentFoundPrice();
						break;
					case ',':
						fleet.previousFoundPrice();
						fleet.showCurrentFoundPrice();
						break;
					case 'x':
						foundPriceMenu = false;
				}
			}
			break;
		}
    }

}
