package adria.activitat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

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
			//Document lectors;
		    //System.out.println(cursor.next().toJson());
			titol = item.getString("titol");
			autor = item.getString("autor");
			genere = item.getString("genere");
			descripcio = item.getString("descripcio");
			any_publicacio = item.getInteger("any_publicacio");
			//any_publicacio = new Date();
			portada = item.getString("portada");
			//lectors = item.get(lectors);
			llibre = new Llibre(titol, autor, genere, descripcio, any_publicacio, portada);
			List<Document> lectors = (List<Document>) item.get("lectors");
			//System.out.println(lectors.size());
			//System.out.println(lectors.toString());
			for (int j = 0; j < lectors.size(); j++)
				{
				Lector newLector = new Lector(lectors.get(j).getString("nom"));
				newLector.addRessenya(lectors.get(j).getString("ressenya"));
				llibre.addUsuari(newLector);
				}
			llibresToReturn.add(llibre);
		}
		return llibresToReturn;
	}

	public void updateBook(Llibre llibre) {
		//Document query = new Document();
        //query.append("titol",llibre.getTitol());
        //Document setData = new Document();
        //setData.append("lectors", llibre.getUsuaris().getLast().toDocument());
        //Document update = new Document();
        //update.append("$set", setData);
        //To update single Document  
        //////connectionToLlibres.updateOne(query, update);
        
        
        Bson filter = Filters.eq("titol",llibre.getTitol());
        Bson update = Updates.push("lectors", llibre.getUsuaris().getLast().toDocument());
        // Defines options that configure the operation to return a document in its post-operation state
        FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
                                            .returnDocument(ReturnDocument.AFTER);
         // Updates the first document that matches the filter and prints the updated document as JSON                                    
        Document result = connectionToLlibres.findOneAndUpdate(filter, update, options);
        //System.out.println(result.toJson());
        
        
		
	}

	public void addDocument(Llibre llibre) {
		// TODO Auto-generated method stub
		Document doc1 = new Document("dada", "llibre").append("titol", llibre.getTitol()).append("autor", llibre.getAutor()).append("genere", llibre.getGenere()).append("descripcio", llibre.getDescripcio()).append("any_publicacio", llibre.getAny_publicacio()).append("portada", llibre.getPortada()).append("lectors", llibre.getUsuaris());
		InsertOneResult result = connectionToLlibres.insertOne(doc1);
		//System.out.println("Inserted a document with the following id: " + result.getInsertedId().asObjectId().getValue());
		//connectionToLlibres.insertOne(llibre.toDocument());
		
	}

	public ArrayList<Llibre> listTitle(String cerca) {
		String titol, autor, genere, descripcio, portada;
		int any_publicacio;
		Llibre llibre;
		ArrayList<Llibre> llibresToReturn = new ArrayList<Llibre>();
		//Bson filter = Filters.regex("titol", "$"+cerca+"$");
		Bson filter = Filters.regex("titol", cerca);
		FindIterable<Document> resultats =connectionToLlibres.find(filter);
		MongoCursor<Document> cursor = resultats.iterator();
		while (cursor.hasNext()) {
			Document item = cursor.next();
			//Document lectors;
		    //System.out.println(cursor.next().toJson());
			titol = item.getString("titol");
			autor = item.getString("autor");
			genere = item.getString("genere");
			descripcio = item.getString("descripcio");
			any_publicacio = item.getInteger("any_publicacio");
			//any_publicacio = new Date();
			portada = item.getString("portada");
			//lectors = item.get(lectors);
			llibre = new Llibre(titol, autor, genere, descripcio, any_publicacio, portada);
			List<Document> lectors = (List<Document>) item.get("lectors");
			//System.out.println(lectors.size());
			//System.out.println(lectors.toString());
			for (int j = 0; j < lectors.size(); j++)
				{
				Lector newLector = new Lector(lectors.get(j).getString("nom"));
				newLector.addRessenya(lectors.get(j).getString("ressenya"));
				llibre.addUsuari(newLector);
				}
			llibresToReturn.add(llibre);
		}
		return llibresToReturn;
	}

	public ArrayList<Llibre> listDates(ArrayList<Integer> resultatDates) {
		String titol, autor, genere, descripcio, portada;
		int any_publicacio;
		Llibre llibre;
		ArrayList<Llibre> llibresToReturn = new ArrayList<Llibre>();
		//Bson filter = Filters.regex("titol", "$"+cerca+"$");
		Bson filter = Filters.and(Filters.gte("any_publicacio",resultatDates.get(0) ),Filters.lte("any_publicacio",resultatDates.get(1)));
		FindIterable<Document> resultats =connectionToLlibres.find(filter);
		MongoCursor<Document> cursor = resultats.iterator();
		while (cursor.hasNext()) {
			Document item = cursor.next();
			//Document lectors;
		    //System.out.println(cursor.next().toJson());
			titol = item.getString("titol");
			autor = item.getString("autor");
			genere = item.getString("genere");
			descripcio = item.getString("descripcio");
			any_publicacio = item.getInteger("any_publicacio");
			//any_publicacio = new Date();
			portada = item.getString("portada");
			//lectors = item.get(lectors);
			llibre = new Llibre(titol, autor, genere, descripcio, any_publicacio, portada);
			List<Document> lectors = (List<Document>) item.get("lectors");
			//System.out.println(lectors.size());
			//System.out.println(lectors.toString());
			for (int j = 0; j < lectors.size(); j++)
				{
				Lector newLector = new Lector(lectors.get(j).getString("nom"));
				newLector.addRessenya(lectors.get(j).getString("ressenya"));
				llibre.addUsuari(newLector);
				}
			llibresToReturn.add(llibre);
		}
		return llibresToReturn;
	}

	
}
