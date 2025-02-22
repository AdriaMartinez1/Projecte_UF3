package adria.activitat;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {

    public ConnectionManager(String databaseName, String collectionName, String nomUsuariMongo, String passwordMongo,
    String uRLMongo) {
super();
    this.databaseName = databaseName;
    this.collectionName = collectionName;
    this.nomUsuariMongo = nomUsuariMongo;
    this.passwordMongo = passwordMongo;
    URLMongo = uRLMongo;
    }

    static String databaseName = "";
    static String collectionName = "";
    static String nomUsuariMongo = "";
    static String passwordMongo = "";
    static String URLMongo = "";
    static MongoCollection<Document> collection;
        
    
        public MongoCollection getConnection()
        {
        String uri = "mongodb+srv://"+nomUsuariMongo+":"+passwordMongo+"@"+URLMongo+"/";
	    MongoClient mongoClient = MongoClients.create(uri);

            // Obtener o crear una base de datos

			MongoDatabase database = mongoClient.getDatabase(databaseName); // <-- Nom de la base de dades
            // Obtener o crear una colección
			collection = database.getCollection(collectionName); // <-- Nom de la col.lecció
                        return collection;

		
    }
}