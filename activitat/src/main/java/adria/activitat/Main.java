package adria.activitat;

import java.util.Scanner;

import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class Main 
{
	
	String databaseName = "BookDatabase";
    String collectionName = "Data";
    String nomUsuariMongo = "Adria";
	String passwordMongo = "exercici1";
	String URLMongo = "cluster0.hlg7r.mongodb.net";
    MongoDatabase mongoconnection = null;


	ConnectionManager mongomanager = null;
    
    
    public void start()
    {
        mongomanager = new ConnectionManager(databaseName, collectionName, nomUsuariMongo, passwordMongo, URLMongo);
        mongoconnection = mongomanager.getConnection();
 
        
    }
    
    public static void main( String[] args )
    {
        Main program = new Main();
        program.start();
    }
}
