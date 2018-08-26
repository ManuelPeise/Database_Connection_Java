package database;

import java.util.*;

public class main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		database d = new database();
		
	
		
		boolean load = d.load_Driver();
		boolean connected = d.connect(load);
		d.insert_User(connected, "Mr", "x");
		
		
		
		
	}

}
