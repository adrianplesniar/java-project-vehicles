package dealership;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Password {
	protected int hash;
	
	public void setPassword(String password) {
		hash = password.hashCode();
	}
	
	public int hashCode(String password) {
		return password.hashCode();
	}
	
	public boolean validatePassword(String password) {
		if(hashCode(password) == hash)
			return true;
		else
			return false;
	}
	
	public void savePassword()
	{
		try {
			PrintWriter writer = new PrintWriter("passwd.txt");
			writer.println(Integer.toString(hash));
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readPassword()
	{
		try {
			Scanner passwd = new Scanner(new File("passwd.txt"));
			while(passwd.hasNextLine()) {
				hash = Integer.parseInt(passwd.nextLine());
			}
		} catch(IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public int getHash() {
		return hash;
	}
}
