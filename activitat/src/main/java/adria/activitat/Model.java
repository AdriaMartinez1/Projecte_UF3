package adria.activitat;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.client.MongoDatabase;

public class Model {
	private final MongoCollection<Document> collection;
	

	public Model(MongoDatabase mongoconnection) {
		this.collection = mongoconnection.getCollection("Data");
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
	
	
	
	

}
