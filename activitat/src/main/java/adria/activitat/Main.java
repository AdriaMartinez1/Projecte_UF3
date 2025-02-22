package adria.activitat;

import java.util.ArrayList;
import java.util.Scanner;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * 
 * Hello world!
 *
 * 
 * 
 */

public class Main
{
	String databaseName = "BookDatabase";
	String collectionName = "Data";
	String nomUsuariMongo = "Adria";
	String passwordMongo = "exercici1";
	String URLMongo = "cluster0.hlg7r.mongodb.net";
	String colleccio = "Data";
	ArrayList<Llibre> resultatConsulta;
	ArrayList<Integer> resultatDates;
	MongoCollection mongoconnection = null;
	ConnectionManager mongomanager = null;
	//Scanner terminalInput = null;

	int option = 0;
	boolean exit = false;
	//ConnectionManager mongomanager = null;
	View view = null;
	Model model;
	String cerca="";
	
	public void start()
	{
		Llibre llibre;
		Lector novaRessenya;
		mongomanager = new ConnectionManager(databaseName, collectionName, nomUsuariMongo, passwordMongo, URLMongo);
		mongoconnection = mongomanager.getConnection();
		view = new View();
		model = new Model(mongoconnection);
		//model.connectToCollection(colleccio);
		while (!exit)
		{
			option = view.showMainMenu();
			System.out.println(option);
			switch (option)
			{
			case 1:
				resultatConsulta = model.listAllDocuments();
				//view.list(resultatConsulta);
				//llibre = view.menuInsertDocument();
				//model.toDocument(llibre);
				llibre = view.menuNewReview(resultatConsulta);
				//System.out.println(llibre.toString());
				model.updateBook(llibre);
				break;
			case 2:
				llibre = view.menuAddNewBook();
				model.addDocument(llibre);
				break;
			case 3:
				resultatConsulta = model.listAllDocuments();
				view.list(resultatConsulta);
				break;
			case 4:
				cerca=view.askTitle();
				resultatConsulta = model.listTitle(cerca);
				view.list(resultatConsulta);
				break;
			case 5:
				resultatDates=view.askDates();
				resultatConsulta = model.listDates(resultatDates);
				view.list(resultatConsulta);
				break;
			case 6:
				exit = true;
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args)
	{
		Main program = new Main();
		program.start();
	}

}