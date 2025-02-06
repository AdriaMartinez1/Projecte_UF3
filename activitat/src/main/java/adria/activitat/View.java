package adria.activitat;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import org.bson.Document;
import com.mongodb.client.FindIterable;

public class View {
    Scanner terminalInput = null;
	int option = 0;
	boolean exit = false;
	//ConnectionManager mongomanager = null;
	
    public int showMainMenu()
    {
    exit = false;
    while (!exit)
        {
            System.out.println("MENU");
            System.out.println("1-Afegir ressenya a llibre");
            System.out.println("2-Insereix un nou llibre");
            System.out.println("3-Obtenir un llistat de tots els llibres");
            System.out.println("4-Cerca de llibres");
            System.out.println("5-Llistar llibres publicats entre dues dates");
            System.out.println("6-Exit");
            terminalInput = new Scanner(System.in);	
            option = terminalInput.nextInt();
            switch (option) {
            case 1:
            	exit = true;
            	break;
            //mongomanager.insertDocumentSingle();
            case 2:
            	exit = true;
            	break;
            //mongomanager.insertDocumentMultiple();
            case 3:
            	exit = true;
            	break;
            //mongomanager.getAllDocuemts();
            case 4:
            	exit = true;
            	break;
            //mongomanager.queryByKey();                
            case 5:
            	exit = true;
            	break;
            case 9:
            	exit = true;
            	break;  
            default: 
            	System.out.println("Incorrect option");
            	break;
            }

        }
        return option;
    }

    

    public Llibre menuInsertDocument()

    {
    	System.out.println("Aqui, demanaria les dades d'un nou llibre");
    	Llibre newLlibre = new Llibre("llibre nou","xxxx xxxx","Misteri","guai",2025 ,"xxxx.jpeg");
		return newLlibre;
    }


	public void list(ArrayList<Llibre> dataConsulta) {
		System.out.println("Books list:");
		for (Llibre itemLlibre : dataConsulta) {
		    System.out.println(itemLlibre.toString());

		// TODO Auto-generated method stub

	}

	}

	

    

}