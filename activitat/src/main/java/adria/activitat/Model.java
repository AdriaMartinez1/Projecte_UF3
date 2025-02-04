package adria.activitat;

import org.bson.Document;

import com.mongodb.client.MongoDatabase;

public class Model {

	public Model(MongoDatabase mongoconnection) {
		// TODO Auto-generated constructor stub
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
