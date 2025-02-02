package adria.activitat;

import java.sql.Date;
import java.util.Scanner;

public class View {

    Scanner terminalInput = null;
	int option = 0;
	boolean exit = false;
	//ConnectionManager mongomanager = null;

    public int showMainMenu()
    {
    while (!exit)
        {
            System.out.println("MENU");
            System.out.println("1-Convertir l'objecte Llibre a un objecte Document");
            System.out.println("2-Insereix un objecte Llibre");
            System.out.println("3-Obté tots els objectes de la col·lecció Llibres");
            System.out.println("4-Obté tots els objectes que compleixen un filtre");
            System.out.println("5-Actualitza el contingut del document associat a l'objecte Llibres");
            System.out.println("5-Elimina un conjunt de dades filtrades a través del valor d'un camp");
            
            System.out.println("9-Exit");
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
    	Llibre newLlibre = new Llibre("llibre nou","xxxx xxxx","Misteri","guai",new Date(2025, 01, 01),"maduro.jpeg");
		return newLlibre;
    	
    }
    
}