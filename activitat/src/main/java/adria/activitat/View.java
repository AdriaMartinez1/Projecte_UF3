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
            case 6:
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
		int i = 1;
		System.out.println("LLitat de llibres:");
		System.out.println("-----------------");
		for (Llibre itemLlibre : dataConsulta) {
			System.out.print(i + "-");
		    System.out.println(itemLlibre.toString());
		    i++;

		// TODO Auto-generated method stub

	}

	}



	public Llibre menuNewReview(ArrayList<Llibre> resultatConsulta) {
			String nom, ressenya;
			list(resultatConsulta);
			Llibre llibre;
			Lector lector;
            System.out.println("Selecciona el número del llibre:");
            terminalInput = new Scanner(System.in);	
	        option = terminalInput.nextInt();
            System.out.println("Introdueix el teu nom:");
            nom = terminalInput.next();
            System.out.println("Introdueix el teu comentari:");
            ressenya = terminalInput.next();
            llibre = resultatConsulta.get(option - 1 );
            lector = new Lector(nom);
            lector.addRessenya(ressenya);
            llibre.addUsuari(lector);
		return llibre;
	}



	public Llibre menuAddNewBook() {
		String titol, autor, genere, descripcio, portada;
		int any_publicacio;
		Llibre llibre;
		 terminalInput = new Scanner(System.in);
		 System.out.println("Introdueix el titol:");
         titol = terminalInput.nextLine();
         System.out.println("Introdueix l'autor:");
         autor = terminalInput.nextLine();
         System.out.println("Introdueix el genere:");
         genere = terminalInput.nextLine();
         System.out.println("Introdueix la descripcio:");
         descripcio = terminalInput.nextLine();
         System.out.println("Introdueix l'any de publicacio:");
	     any_publicacio = terminalInput.nextInt();
         System.out.println("Introdueix el nom del fitxer de la portada:");
         terminalInput = new Scanner(System.in);
         portada = terminalInput.nextLine();
		 llibre = new Llibre(titol, autor, genere, descripcio, any_publicacio, portada);
		return llibre;
	}



	public String askTitle() {
		String consulta="";
		terminalInput = new Scanner(System.in);
		System.out.println("Introdueix una paraula o text que coincideixi amb el titiol del llibre");
		consulta=terminalInput.nextLine();
		return consulta;
	}



	



	public ArrayList<Integer> askDates() {
		int temp;
		ArrayList<Integer> dates = new ArrayList<Integer>();
		terminalInput = new Scanner(System.in);
		System.out.println("Introdueix el primer any de publicacio del llibre");
		 temp = terminalInput.nextInt();
		 dates.add(temp);
		 System.out.println("Introdueix el segon any de publicacio del llibre");
		 temp = terminalInput.nextInt();
		 dates.add(temp);
		return dates;
	}

	

    

}