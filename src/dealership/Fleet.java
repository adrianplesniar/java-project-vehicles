package dealership;

import java.io.*;
import java.util.Scanner;

public class Fleet extends Vehicle {
	private static final long serialVersionUID = 1L;
	protected Vehicle vehicles[];
	protected Vehicle foundPrice[];
	protected Vehicle foundMake[];
	protected Vehicle sorted[];
	protected int size;
	protected int quantity;
	protected int current;
	protected int currentFoundPrice;
	protected int sizeFoundPrice;
	protected int currentFoundMake;
	protected int sizeFoundMake;
	protected int currentSorted;
	private int i;
	
	public Fleet() {
		size=0;
		quantity=0;
	}
	
	public Fleet(int size)
	{
		this.size=size;
		vehicles = new Vehicle[size];
		for (i=0; i<size; i++)
			vehicles[i]=new Vehicle();
		quantity=0;
		current=-1;
		currentFoundPrice=-1;
		currentFoundMake=-1;
		currentSorted=-1;
	}
	
	public void newFleet(int size) {
		this.size=size;
		vehicles=new Vehicle[size];
		for (i=0; i<size; i++)
			vehicles[i]=new Vehicle();
		quantity=0;
		current=-1;
		currentFoundPrice=-1;
		currentFoundMake=-1;
		currentSorted=-1;
	}
	
	public void clearAll() {
		for (i=0; i<size; i++)
			vehicles[i]=new Vehicle();
		quantity=0;
		current=-1;
		currentFoundPrice=-1;
		currentFoundMake=-1;
		currentSorted=-1;
	}
	
	public void addVehicle(Vehicle v) {
		vehicles[quantity] = v;
		current=quantity;
		quantity++;
	}
	
	public boolean updateCurrentVehicle(Vehicle v) {
		if(current == -1)
			return false;
		else {
			vehicles[current] = v;
			return true;
		}
	}
	
	public int checkCurrentVehicleClass() {
		if(current == -1)
			return 0;
		else {
			if(vehicles[current].getClass().getSimpleName().equals("GasAutomobile"))
				return 1;
			else if(vehicles[current].getClass().getSimpleName().equals("ElectricAutomobile"))
				return 2;
			else if(vehicles[current].getClass().getSimpleName().equals("Motorcycle"))
				return 3;
			else
				return 4;
		}
	}
	
	public void printFleet() {
        for (int i = 0; i < quantity; i++) {
            vehicles[i].print();
            System.out.println("Klasa: " + vehicles[i].getClass());
            System.out.printf("%n");
        }
    }
	
	public boolean setCurrent(int index) {
		if(index>=0 && index<quantity) {
			current=index;
			return false;
		}
		else
			return true;
	}
	
	public void next() {
		if(current<quantity-1)
			current++;
	}
	
	public void previous() {
		if(current>0)
			current--;
	}
	
	public void showCurrent() {
		System.out.println("\n\n");
		if(current>=0)
			vehicles[current].showCurrent();
	}
	
	public void deleteCurrent() {
		if(current>=0 && quantity>1) {
			for(i=current; i<quantity-1; i++)
				vehicles[i]=vehicles[i+1];
			quantity--;
			if(current>0)
				current--;
		} else {
			if(quantity==1) {
				current=-1;
				quantity=0;
			}
		}
	}
	
	//search price
	
	public boolean searchPrice(double min, double max) {
		foundPrice = new Vehicle[size];
		sizeFoundPrice = 0;
		currentFoundPrice = -1;
		
		for(i = 0; i<quantity; i++)
		{
			if(vehicles[i].getPrice() >= min && vehicles[i].getPrice() <= max)
			{
				foundPrice[sizeFoundPrice]=vehicles[i];
				sizeFoundPrice++;
			}
		}
		if(sizeFoundPrice != 0)
		{
			currentFoundPrice = 0;
			return true;
		}
		else
			return false;
	}
	
	public void showCurrentFoundPrice()
	{
		if (currentFoundPrice>=0)
			foundPrice[currentFoundPrice].showCurrent();
	}
	
	public void nextFoundPrice()
	{
		if(currentFoundPrice<sizeFoundPrice-1)
			currentFoundPrice++;
	}

	public void previousFoundPrice()
	{
		if(currentFoundPrice>0)
			currentFoundPrice--;
	}
	
	//search make

	public boolean searchMake(String makeName)
	{
		foundMake = new Vehicle[size];
		sizeFoundMake = 0;
		currentFoundMake = -1;
		
		for(i = 0; i<quantity; i++)
		{
			if(vehicles[i].getMake().equalsIgnoreCase(makeName))
			{
				foundMake[sizeFoundMake]=vehicles[i];
				sizeFoundMake++;
			}
		}
		
		if(sizeFoundMake != 0)
		{
			currentFoundMake = 0;
			return true;
		}
		else
			return false;
	}

	public void showCurrentFoundMake()
	{
		if (currentFoundMake>=0)
			foundMake[currentFoundMake].showCurrent();
	}
	
	public void nextFoundMake()
	{
		if(currentFoundMake<sizeFoundMake-1)
			currentFoundMake++;
	}

	public void previousFoundMake()
	{
		if(currentFoundMake>0)
			currentFoundMake--;
	}

	//sorted methods
	
	public void showSorted()
	{
		if (currentSorted>=0)
			sorted[currentSorted].showCurrent();
	}
	
	public void nextSorted()
	{
		if(currentSorted<quantity-1)
			currentSorted++;
	}

	public void previousSorted()
	{
		if(currentSorted>0)
			currentSorted--;
	}
	
	//sort year ascending
	
	public boolean sortYearAscending()
	{
		boolean isSorted = false;
		sorted = new Vehicle[quantity];
		for(i=0;i<quantity;i++) {
			sorted[i] = vehicles[i];
		}
		currentSorted = -1;
		
	    while(!isSorted) {
	        isSorted = true;
	        for (i = 0; i < quantity - 1; i++) {
	        	if (sorted[i].getYear()>sorted[i+1].getYear()) {
	        		Class<? extends Vehicle> vSubClass = sorted[i].getClass();
  					Vehicle temp;
					try {
						temp = vSubClass.getDeclaredConstructor().newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
  					temp = sorted[i];
  					sorted[i] = sorted[i+1];
  					sorted[i+1] = temp;
  					isSorted = false;
  				}
	        }
	    }
		
		if(quantity>0)
		{
			currentSorted = 0;
			return true;
		}
		else
			return false;
	}
	
	//sort year descending
	
	public boolean sortYearDescending()
	{
		boolean isSorted = false;
		sorted = new Vehicle[quantity];
		for(i=0;i<quantity;i++) {
			sorted[i] = vehicles[i];
		}
		currentSorted = -1;
		
	    while(!isSorted) {
	        isSorted = true;
	        for (i = 0; i < quantity - 1; i++) {
	        	if (sorted[i].getYear()<sorted[i+1].getYear()) {
	        		Class<? extends Vehicle> vSubClass = sorted[i].getClass();
  					Vehicle temp;
					try {
						temp = vSubClass.getDeclaredConstructor().newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
  					temp = sorted[i];
  					sorted[i] = sorted[i+1];
  					sorted[i+1] = temp;
  					isSorted = false;
  				}
	        }
	    }
		
		if(quantity>0)
		{
			currentSorted = 0;
			return true;
		}
		else
			return false;
	}
	
	//sort make ascending
	
	public boolean sortMakeAscending()
	{
		boolean isSorted = false;
		sorted = new Vehicle[quantity];
		for(i=0;i<quantity;i++) {
			sorted[i] = vehicles[i];
		}
		currentSorted = -1;
		
	    while(!isSorted) {
	        isSorted = true;
	        for (i = 0; i < quantity - 1; i++) {
	        	if (sorted[i].getMake().compareToIgnoreCase(sorted[i+1].getMake()) > 0) {
	        		Class<? extends Vehicle> vSubClass = sorted[i].getClass();
  					Vehicle temp;
					try {
						temp = vSubClass.getDeclaredConstructor().newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
  					temp = sorted[i];
  					sorted[i] = sorted[i+1];
  					sorted[i+1] = temp;
  					isSorted = false;
  				}
	        }
	    }
		
		if(quantity>0)
		{
			currentSorted = 0;
			return true;
		}
		else
			return false;
	}
	
	//sort make descending
	
	public boolean sortMakeDescending()
	{
		boolean isSorted = false;
		sorted = new Vehicle[quantity];
		for(i=0;i<quantity;i++) {
			sorted[i] = vehicles[i];
		}
		currentSorted = -1;
		
	    while(!isSorted) {
	        isSorted = true;
	        for (i = 0; i < quantity - 1; i++) {
	        	if (sorted[i].getMake().compareToIgnoreCase(sorted[i+1].getMake()) < 0) {
	        		Class<? extends Vehicle> vSubClass = sorted[i].getClass();
  					Vehicle temp;
					try {
						temp = vSubClass.getDeclaredConstructor().newInstance();
					} catch (Exception e) {
						e.printStackTrace();
					}
  					temp = sorted[i];
  					sorted[i] = sorted[i+1];
  					sorted[i+1] = temp;
  					isSorted = false;
  				}
	        }
	    }
		
		if(quantity>0)
		{
			currentSorted = 0;
			return true;
		}
		else
			return false;
	}
	
	//save & read file
	
	public void saveFile()
	{
		try {
			PrintWriter writer = new PrintWriter("data.txt");
			writer.println(Integer.toString(quantity));
			writer.println(Integer.toString(size));
			writer.close();
			
			FileOutputStream fileOut = new FileOutputStream("vehicles.ser");
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
			outputStream.writeObject(vehicles);
			outputStream.close();
			fileOut.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile()
	{
		try {
			Scanner data = new Scanner(new File("data.txt"));
			while(data.hasNextLine()) {
				quantity = Integer.parseInt(data.nextLine());
				size = Integer.parseInt(data.nextLine());
			}
			  
			FileInputStream fileIn = new FileInputStream("vehicles.ser");
			ObjectInputStream inputStream = new ObjectInputStream(fileIn);
			vehicles = (Vehicle[]) inputStream.readObject();
			inputStream.close();
			fileIn.close();
		} catch(IOException e) {
			e.printStackTrace();
			return;
		} catch(ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}
		
		if(quantity>0) {
			current=0;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
