package dealership;

import java.io.*;
import java.util.Scanner;

public class Fleet extends Vehicle {
	private static final long serialVersionUID = 1L;
	protected Vehicle vehicles[];
	protected int size;
	protected int quantity;
	protected int current;
	private int i;
	
	public Fleet() {
		size=0;
		quantity=0;
	}
	
	public Fleet(int size)
	{
		this.size=size;
		vehicles=new Vehicle[size];
		for (i=0; i<size; i++)
			vehicles[i]=new Vehicle();
		quantity=0;
		current=-1;
	}
	
	public void newFleet(int size) {
		this.size=size;
		vehicles=new Vehicle[size];
		for (i=0; i<size; i++)
			vehicles[i]=new Vehicle();
		quantity=0;
		current=-1;
	}
	
	public void clearAll() {
		for (i=0; i<size; i++)
			vehicles[i]=new Vehicle();
		quantity=0;
		current=-1;
	}
	
	public void addVehicle(Vehicle v) {
		vehicles[quantity] = v;
		current=quantity;
		quantity++;
	}
	
	public void printFleet() {
        for (int i = 0; i < quantity; i++) {
            vehicles[i].print();
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
	
	public Vehicle showCurrent() {
		if(current>=0)
			return vehicles[current] ;
		return null;
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
	}
	
	public int getSize() {
		return size;
	}
}
