package database;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.*;

public class database 
{
	
	Connection conn;
	//load driver
	
	public boolean load_Driver()
	{
		boolean loaded=false;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Treiber geladen");
			loaded=true;
			}catch(Exception ex){
				System.out.println("Fehler");
				ex.printStackTrace();
				loaded=false;
			}
		
		
		return loaded;
	}
	
	public boolean connect(boolean loaded)
	{	
		String url="jdbc:mysql://localhost:3306/adressen";
		String user="Mr_X";
		String pswd="yyyy";
		boolean connected=false;
		
		if(loaded==true)
		{
			try{
				
				conn=DriverManager.getConnection(url,user,pswd);
				connected=true;
				System.out.println("Verunden");
			
			}catch(SQLException ex){
				
				connected=false;
				System.out.println("Verbindung fehlgeschlagen");
				System.out.println(ex.getMessage());
			}
			
			return connected;
		
		}else{
			
			System.out.println("Treiber nicht geladen!");
		}
		
		return connected;
	}
	
	public void insert_User(boolean loaded,String firstname,String lastname)
	{	
		
		if(loaded==true)
		{
			String insert="insert into personen values(null,'"+firstname+"','"+lastname+"');";
			try{
				
				Statement stmt =conn.createStatement();
				
				stmt.executeUpdate(insert);
				
				stmt.close();
				
				System.out.println("erfolgreich!");
				
			}catch(SQLException ex){
				System.out.println("Fehler");
				System.out.println("SQLException: "+ex.getMessage());
				System.out.println("SQLstate: "+ex.getSQLState());
				System.exit(-1);
			}
			
		
		
		
		}else{
			System.out.println("nicht verbunden!");
		}
	}

}
