package adria.activitat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import com.mongodb.client.MongoDatabase;

public class Model {
	MongoDatabase database;
    MongoCollection<Document> connectionToLlibres;
	
	public Model(MongoDatabase mongoconnection) {
		// TODO Auto-generated constructor stub
		this.database = mongoconnection;
	}
	
	public void connectToCollection(String collection)
		{
		connectionToLlibres = database.getCollection(collection);	
		}

	public void toDocument(Llibre llibre) {
		Document doc = new Document("titol", llibre.getTitol())
                .append("autor", llibre.getAutor())
                .append("genere", llibre.getGenere())
                .append("descripcio", llibre.getDescripcio())
                .append("any_publicacio", llibre.getAny_publicacio())
                .append("portada", llibre.getPortada());
        System.out.println("Document creat: " + doc.toJson());
	}
	
	public FindIterable<Document> allBooks()
	{
		return null;
	}

	public ArrayList<Llibre> listAllDocuments() {
			String titol, autor, genere, descripcio, portada;
			int any_publicacio;
			Llibre llibre;
			ArrayList<Llibre> llibresToReturn = new ArrayList<Llibre>();
			//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		FindIterable<Document> resultats =  connectionToLlibres.find();
		MongoCursor<Document> cursor = resultats.iterator();
		while (cursor.hasNext()) {
			Document item = cursor.next();
		    //System.out.println(cursor.next().toJson());
			titol = item.getString("titol");
			autor = item.getString("autor");
			genere = item.getString("genere");
			descripcio = item.getString("descripcio");
			any_publicacio = item.getInteger("any_publicacio");
			//any_publicacio = new Date();
			portada = item.getString("portada");
			llibre = new Llibre(titol, autor, genere, descripcio, any_publicacio, portada);
			llibresToReturn.add(llibre);
		}
		return llibresToReturn;
	}
}
