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
	
	Scanner terminalInput = null;
	int option = 0;
	boolean exit = false;
	//ConnectionManager mongomanager = null;
    View view = null;
    Model model;
    
    
    public void start()
    {
    	Llibre llibre;
        mongomanager = new ConnectionManager(databaseName, collectionName, nomUsuariMongo, passwordMongo, URLMongo);
        mongoconnection = mongomanager.getConnection();
        view = new View();
        model = new Model(mongoconnection);
        option = view.showMainMenu();
        System.out.println(option);
        switch (option)
        {
        case 1:
        	llibre = view.menuInsertDocument();
        	model.toDocument(llibre);
        }
        
    }
    
    public static void main( String[] args )
    {
        Main program = new Main();
        program.start();
    }
}
