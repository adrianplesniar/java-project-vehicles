package dealership;

import java.util.Scanner;

public class Menu {
	private static Scanner scanner = new Scanner(System.in);
	static String make, model, bodyStyle, type, isStreetLegal, makeName, passwd;
	static int horsepower, year, cargoCapacity, drivingRange, batteryLife, min, max;
	static double price, fuelEconomy, engineCapacity;
	static int size, index;
	static Fleet fleet = new Fleet();
	static Password password = new Password();
	static boolean valid, sortMenu;

	public static void main(String[] args) {
		System.out.print("Wprowadz maksymaln� ilo�� pojazd�w: ");
		size = scanner.nextInt();
		fleet = new Fleet(size);
		System.out.print("Ustaw has�o: ");
		passwd = scanner.next();
		password.setPassword(passwd);
		
		char ch = ' ';
    	while (ch != 'X' || ch !='x')
    	{
	      	mainMenu();
	    	ch = select();
	    	output(ch);
	    	if(ch == 'X' || ch =='x') {
	    		System.out.println("Do widzenia");
	    		System.exit(0);
	    	}
    	}
	}
	
	public static void mainMenu() {
		System.out.println("\n\nMENU");
		System.out.println("----\n");
		System.out.println("0 - Nowa baza");
		System.out.println("1 - Dodaj pojazd");
		System.out.println("2 - Aktualizuj bie��cy");
		System.out.println("3 - Zapisz do pliku");
		System.out.println("4 - Odczyt z pliku");
		System.out.println("5 - Wyswietl bie��cy");
		System.out.println("6 - Ustaw bie��cy");
		System.out.println("7 - Znajdz pojazdy mieszcz�ce si� w podanym przedziale cenowym");
		System.out.println("8 - Znajdz pojazdy o podanej nazwie marki");
		System.out.println("9 - Posortuj pojazdy");
		System.out.println("p - Ustaw nowe has�o");
		System.out.println("x - Wyjdz");
	}
	
	public static void vehicleMenu() {
		System.out.println("\n\nWybierz rodzaj pojazdu");
		System.out.println("----------------------\n");
		System.out.println("0 - Samoch�d spalinowy");
		System.out.println("1 - Samoch�d elektryczny");
		System.out.println("2 - Motocykl");
		System.out.println("x - Powr�t do MENU");
	}
	
	public static void showCurrentMenu() {
		System.out.println("\n\n------------------");
		System.out.println("Przegladaj pojazdy");
		System.out.println(". - Nastepny");
		System.out.println(", - Poprzedni");
		System.out.println("d - Usu� bie��cy");
		System.out.println("x - Powr�t do MENU");
	}
	
	public static void showCurrentFoundPriceMenu() {
		System.out.println("\n\n------------------");
		System.out.println("Przegladaj pojazdy z podanego przedzia�u cenowego");
		System.out.println(". - Nastepny znaleziony");
		System.out.println(", - Poprzedni znaleziony");
		System.out.println("x - Powr�t do MENU");
	}
	
	public static void showCurrentFoundMakeMenu() {
		System.out.println("\n\n------------------");
		System.out.println("Przegladaj pojazdy o podanej nazwie marki");
		System.out.println(". - Nastepny znaleziony");
		System.out.println(", - Poprzedni znaleziony");
		System.out.println("x - Powr�t do MENU");
	}
	
	public static void showSortedMenu() {
		System.out.println("\n\n------------------");
		System.out.println("0 - Sortuj wed�ug roku rosn�co");
		System.out.println("1 - Sortuj wed�ug roku malej�co");
		System.out.println("2 - Sortuj wed�ug marki rosn�co");
		System.out.println("3 - Sortuj wed�ug marki malej�co");
		System.out.println(". - Nastepny posortowany");
		System.out.println(", - Poprzedni posortowany");
		System.out.println("x - Powr�t do MENU");
	}
	
	public static char select() {
	System.out.print ("Wybierz: ");
	String ch = scanner.next();
	System.out.printf("%n");
	char selected = ' ';
	if( ch.length() > 0 )
		selected = ch.charAt(0);
	
	return selected;
    }
	
	public static void output(char ch) {
		switch (ch) {
		case '0':
			System.out.println("Czy na pewno chcesz uyworzy� now� baz�? t = tak");
			String newDatabase = scanner.next();
			if(newDatabase.charAt(0) == 't') {
				fleet.clearAll();
				System.out.print("Wprowadz maksymaln� ilo�� pojazd�w: ");
				size = scanner.nextInt();
				fleet = new Fleet(size);
				System.out.print("Ustaw has�o: ");
				passwd = scanner.next();
				password.setPassword(passwd);
				break;
			}
			break;	
		case '1':
			System.out.print("Podaj has�o: ");
			passwd = scanner.next();
			if(!password.validatePassword(passwd)) {
				System.out.println("Podane has�o jest nieprawid�owe");
				break;
			}
			vehicleMenu();
			ch = select();
			switch(ch) {
			case '0':
				System.out.print("Marka: ");
				make = scanner.next() + scanner.nextLine();
				System.out.print("Model: ");
				model = scanner.next() + scanner.nextLine();
				valid = false;
				do {
					System.out.print("Moc silnika (KM): ");
					if(scanner.hasNextInt()) {
						horsepower = scanner.nextInt();
						if(horsepower>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
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
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
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
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}	
				}while(valid == false);
				System.out.print("Nadwozie: ");
				bodyStyle = scanner.next() + scanner.nextLine();
				valid = false;
				do {
					System.out.print("Pojemno�� baga�nika: ");
					if(scanner.hasNextInt()) {
						cargoCapacity = scanner.nextInt();
						if(cargoCapacity>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}	
				}while(valid == false);
				valid = false;
				do {
					System.out.print("Pojemno�� silnika (l): ");
					if(scanner.hasNextDouble()) {
						engineCapacity = scanner.nextDouble();
						if(engineCapacity>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}	
				}while(valid == false);
				System.out.print("Spalanie (l/100km): ");
				fuelEconomy = scanner.nextDouble();
				fleet.addVehicle(new GasAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, engineCapacity, fuelEconomy));
				break;
			case '1':
				System.out.print("Marka: ");
				make = scanner.next() + scanner.nextLine();
				System.out.print("Model: ");
				model = scanner.next() + scanner.nextLine();
				valid = false;
				do {
					System.out.print("Moc silnika (KM): ");
					if(scanner.hasNextInt()) {
						horsepower = scanner.nextInt();
						if(horsepower>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
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
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
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
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}	
				}while(valid == false);
				System.out.print("Nadwozie: ");
				bodyStyle = scanner.next() + scanner.nextLine();
				valid = false;
				do {
					System.out.print("Pojemno�� baga�nika: ");
					if(scanner.hasNextInt()) {
						cargoCapacity = scanner.nextInt();
						if(cargoCapacity>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}
				}while(valid == false);
				valid = false;
				do {
					System.out.print("Zasi�g (km): ");
					if(scanner.hasNextInt()) {
						drivingRange = scanner.nextInt();
						if(drivingRange>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}
				}while(valid == false);
				valid = false;
				do {
					System.out.print("�ycie baterii (km): ");
					if(scanner.hasNextInt()) {
						batteryLife = scanner.nextInt();
						if(batteryLife>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}
				}while(valid == false);
				fleet.addVehicle(new ElectricAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, drivingRange, batteryLife));
				break;
			case '2':
				System.out.print("Marka: ");
				make = scanner.next() + scanner.nextLine();
				System.out.print("Model: ");
				model = scanner.next() + scanner.nextLine();
				valid = false;
				do {
					System.out.print("Moc silnika (KM): ");
					if(scanner.hasNextInt()) {
						horsepower = scanner.nextInt();
						if(horsepower>0)
							valid = true;
						else
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
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
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
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
							System.out.println("Podano b��dn� warto��");
					} else {
						System.out.println("Podano b��dn� warto��");
						scanner.next();
					}	
				}while(valid == false);
				System.out.print("Rodzaj: ");
				type = scanner.next() + scanner.nextLine();
				System.out.print("Homologacja: ");
				isStreetLegal = scanner.next();
				fleet.addVehicle(new Motorcycle(make, model, horsepower, year, price, type, isStreetLegal));
				break;
			case 'x':
				break;
			}
			break;
		case '2':
			System.out.print("Podaj has�o: ");
			passwd = scanner.next();
			if(!password.validatePassword(passwd)) {
				System.out.println("Podane has�o jest nieprawid�owe");
				break;
			}
			System.out.println("Czy na pewno chcesz zaktualizowa� bierz�cy element? t = tak");
			String updateCurrent = scanner.next();
			if(updateCurrent.charAt(0) == 't') {
				switch(fleet.checkCurrentVehicleClass()) {
					case 0:
						System.out.println("Brak pojazd�w do zaktualizowania");
						break;
					case 1:
						System.out.print("Marka: ");
						make = scanner.next() + scanner.nextLine();
						System.out.print("Model: ");
						model = scanner.next() + scanner.nextLine();
						valid = false;
						do {
							System.out.print("Moc silnika (KM): ");
							if(scanner.hasNextInt()) {
								horsepower = scanner.nextInt();
								if(horsepower>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
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
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
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
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}	
						}while(valid == false);
						System.out.print("Nadwozie: ");
						bodyStyle = scanner.next() + scanner.nextLine();
						valid = false;
						do {
							System.out.print("Pojemno�� baga�nika: ");
							if(scanner.hasNextInt()) {
								cargoCapacity = scanner.nextInt();
								if(cargoCapacity>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}	
						}while(valid == false);
						valid = false;
						do {
							System.out.print("Pojemno�� silnika (l): ");
							if(scanner.hasNextDouble()) {
								engineCapacity = scanner.nextDouble();
								if(engineCapacity>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}	
						}while(valid == false);
						System.out.print("Spalanie (l/100km): ");
						fuelEconomy = scanner.nextDouble();
						fleet.updateCurrentVehicle(new GasAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, engineCapacity, fuelEconomy));
						break;
					case 2:
						System.out.print("Marka: ");
						make = scanner.next() + scanner.nextLine();
						System.out.print("Model: ");
						model = scanner.next() + scanner.nextLine();
						valid = false;
						do {
							System.out.print("Moc silnika (KM): ");
							if(scanner.hasNextInt()) {
								horsepower = scanner.nextInt();
								if(horsepower>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
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
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
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
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}	
						}while(valid == false);
						System.out.print("Nadwozie: ");
						bodyStyle = scanner.next() + scanner.nextLine();
						valid = false;
						do {
							System.out.print("Pojemno�� baga�nika: ");
							if(scanner.hasNextInt()) {
								cargoCapacity = scanner.nextInt();
								if(cargoCapacity>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}
						}while(valid == false);
						valid = false;
						do {
							System.out.print("Zasi�g (km): ");
							if(scanner.hasNextInt()) {
								drivingRange = scanner.nextInt();
								if(drivingRange>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}
						}while(valid == false);
						valid = false;
						do {
							System.out.print("�ycie baterii (km): ");
							if(scanner.hasNextInt()) {
								batteryLife = scanner.nextInt();
								if(batteryLife>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}
						}while(valid == false);
						fleet.updateCurrentVehicle(new ElectricAutomobile(make, model, horsepower, year, price, bodyStyle, cargoCapacity, drivingRange, batteryLife));
						break;
					case 3:
						System.out.print("Marka: ");
						make = scanner.next() + scanner.nextLine();
						System.out.print("Model: ");
						model = scanner.next() + scanner.nextLine();
						valid = false;
						do {
							System.out.print("Moc silnika (KM): ");
							if(scanner.hasNextInt()) {
								horsepower = scanner.nextInt();
								if(horsepower>0)
									valid = true;
								else
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
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
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
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
									System.out.println("Podano b��dn� warto��");
							} else {
								System.out.println("Podano b��dn� warto��");
								scanner.next();
							}	
						}while(valid == false);
						System.out.print("Rodzaj: ");
						type = scanner.next() + scanner.nextLine();
						System.out.print("Homologacja: ");
						isStreetLegal = scanner.next();
						fleet.updateCurrentVehicle(new Motorcycle(make, model, horsepower, year, price, type, isStreetLegal));
						break;
				}
			}
			break;
		case '3':
			fleet.saveFile();
			password.savePassword();
			break;
		case '4':
			fleet.readFile();
			password.readPassword();
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
						System.out.println("Czy na pewno chcesz usun�� bierz�cy element? t = tak");
						String deleteCurrent = scanner.next();
						if(deleteCurrent.charAt(0) == 't') {
							System.out.print("Podaj has�o: ");
							passwd = scanner.next();
							if(!password.validatePassword(passwd)) {
								System.out.println("Podane has�o jest nieprawid�owe");
								System.out.println("Pojazd nie zosta� usuni�ty");
								break;
							} else {
								fleet.deleteCurrent();
								System.out.println("Usuni�to bie��cy");
								break;
							}
						} else {
							System.out.println("Pojazd nie zosta� usuni�ty");
							break;
						}
					case 'x':
						currentMenu = false;
				}
			}
			break;
		case '6':
			System.out.print("Podaj warto�� indeksu: ");
			index = scanner.nextInt();
			int maxIndex = fleet.getQuantity()-1;
			if(fleet.setCurrent(index)) {
				System.out.println("Wprowadzono b��dn� warto��! Podaj warto� z przedzia�u <0," + maxIndex + ">.");
			} else {
				fleet.setCurrent(index);
			}
			break;
		case '7':
			valid = false;
			do {
				System.out.println("Podaj cene min: ");
				if(scanner.hasNextInt()) {
					min = scanner.nextInt();
					if(min>=0)
						valid = true;
					else
						System.out.println("Podano b��dn� warto��");
				} else {
					System.out.println("Podano b��dn� warto��");
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
						System.out.println("Podano b��dn� warto��");
				} else {
					System.out.println("Podano b��dn� warto��");
					scanner.next();
				}	
			}while(valid == false);
			if(!fleet.searchPrice(min, max)) {
				System.out.println("Nic nie znaleziono.");
				break;
			}
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
		case '8':
			System.out.println("Podaj szukan� nazw� marki: ");
			makeName = scanner.next();
			System.out.println(makeName);
			if(!fleet.searchMake(makeName)) {
				System.out.println("Nic nie znaleziono.");
				break;
			}
			else
				fleet.showCurrentFoundMake();
			boolean foundMakeMenu = true;
			while(foundMakeMenu) {
				showCurrentFoundMakeMenu();
				ch = select();
				switch(ch) {
					case '.':
						fleet.nextFoundMake();
						fleet.showCurrentFoundMake();
						break;
					case ',':
						fleet.previousFoundMake();
						fleet.showCurrentFoundMake();
						break;
					case 'x':
						foundMakeMenu = false;
				}
			}
			break;
		case '9':
			if(fleet.getQuantity() <= 0)
				System.out.println("Brak element�w do posortowania.");
			else {
				System.out.print("Podaj has�o: ");
				passwd = scanner.next();
				if(!password.validatePassword(passwd)) {
					System.out.println("Podane has�o jest nieprawid�owe");
					break;
				}
				sortMenu = true;
				while(sortMenu) {
					showSortedMenu();
					ch = select();
					switch(ch) {
						case '0':
							fleet.sortYearAscending();
							fleet.showSorted();
							break;
						case '1':
							fleet.sortYearDescending();
							fleet.showSorted();
							break;
						case '2':
							fleet.sortMakeAscending();
							fleet.showSorted();
							break;
						case '3':
							fleet.sortMakeDescending();
							fleet.showSorted();
							break;
						case '.':
							fleet.nextSorted();
							fleet.showSorted();
							break;
						case ',':
							fleet.previousSorted();
							fleet.showSorted();
							break;
						case 'x':
							sortMenu = false;
					}
				}
			}
			break;
		case 'p':
			System.out.print("Podaj stare has�o: ");
			passwd = scanner.next();
			if(!password.validatePassword(passwd)) {
				System.out.println("Podane has�o jest nieprawid�owe");
				break;
			}
			System.out.print("Podaj nowe has�o: ");
			passwd = scanner.next();
			password.setPassword(passwd);
			System.out.print("Nowe has�o zosta�o ustawione");
			break;
		case 'w':
			fleet.printFleet();
			break;
		}
    }

}
