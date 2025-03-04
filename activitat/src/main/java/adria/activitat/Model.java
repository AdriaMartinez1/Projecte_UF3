package adria.activitat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Model {
	MongoCollection database;
    //MongoCollection<Document> connectionToLlibres;
	
	public Model(MongoCollection mongoconnection) {
		// TODO Auto-generated constructor stub
		this.database = mongoconnection;
	}
	
//	public void connectToCollection(String collection)
//		{
//		connectionToLlibres = database.getCollection(collection);	
//		}

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

		ArrayList<Llibre> llibresToReturn = new ArrayList<Llibre>();
		//FindIterable<Document> resultats =  database.find();
	
	///////////////////////////NOU CODI
	
	 try {
         HttpClient client = HttpClient.newHttpClient();
         HttpRequest request = HttpRequest.newBuilder()
                 .uri(new URI("https://m6-uf-3-api-tau.vercel.app/list"))
                 .GET()
                 .build();

         CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
			try {
				TimeUnit.SECONDS.sleep(5); // Això ho posem per esperar a que s'enviin les dades
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         responseFuture.thenAccept(response -> {
 			String titol, autor, genere, descripcio, portada;
			int any_publicacio;
			Llibre llibre;

             String responseBody = response.body();
             //System.out.println(responseBody);
             //System.out.println(".........");

             // Parse JSON response manually
             JSONArray jsonArray = new JSONArray(responseBody);
             //jsonArray2 = jsonArray;
             for (int i = 0; i < jsonArray.length(); i++) {
                 JSONObject jsonObject = jsonArray.getJSONObject(i);
                 //User user = new User();
                 //user.setName(jsonObject.getString("name"));
                 //user.setEmail(jsonObject.getString("email"));
                 Document item = Document.parse( jsonObject.toString() );
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
//     			//System.out.println(lectors.size());
//     			//System.out.println(lectors.toString());
     			for (int j = 0; j < lectors.size(); j++)
     				{
     				Lector newLector = new Lector(lectors.get(j).getString("nom"));
     				newLector.addRessenya(lectors.get(j).getString("ressenya"));
     				llibre.addUsuari(newLector);
     				}
     			llibresToReturn.add(llibre);
             
         }
         }).exceptionally(e -> {
             e.printStackTrace();
             return null;
         });

     } catch (Exception e) {
         e.printStackTrace();
     }
	
	
	
	
	
	////////////////////////////// FI NOU CODI
	
	
	
	
	// FindIterable<Document> resultats =  database.find();
	//MongoCursor<Document> cursor = resultats.iterator();
	 
	 

	return llibresToReturn;

     }
	
	
//	public ArrayList<Llibre> listAllDocuments() {
//			String titol, autor, genere, descripcio, portada;
//			int any_publicacio;
//			Llibre llibre;
//			ArrayList<Llibre> llibresToReturn = new ArrayList<Llibre>();
//			//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//		FindIterable<Document> resultats =  database.find();
//		MongoCursor<Document> cursor = resultats.iterator();
//		while (cursor.hasNext()) {
//			Document item = cursor.next();
//			//Document lectors;
//		    //System.out.println(cursor.next().toJson());
//			titol = item.getString("titol");
//			autor = item.getString("autor");
//			genere = item.getString("genere");
//			descripcio = item.getString("descripcio");
//			any_publicacio = item.getInteger("any_publicacio");
//			//any_publicacio = new Date();
//			portada = item.getString("portada");
//			//lectors = item.get(lectors);
//			llibre = new Llibre(titol, autor, genere, descripcio, any_publicacio, portada);
//			List<Document> lectors = (List<Document>) item.get("lectors");
//			//System.out.println(lectors.size());
//			//System.out.println(lectors.toString());
//			for (int j = 0; j < lectors.size(); j++)
//				{
//				Lector newLector = new Lector(lectors.get(j).getString("nom"));
//				newLector.addRessenya(lectors.get(j).getString("ressenya"));
//				llibre.addUsuari(newLector);
//				}
//			llibresToReturn.add(llibre);
//		}
//		return llibresToReturn;
//	}

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
        Document result = (Document) database.findOneAndUpdate(filter, update, options);
        //System.out.println(result.toJson());
        
        
		
	}

	public void addDocument(Llibre llibre) {
		// TODO Auto-generated method stub
		//Document doc1 = new Document("dada", "llibre").append("titol", llibre.getTitol()).append("autor", llibre.getAutor()).append("genere", llibre.getGenere()).append("descripcio", llibre.getDescripcio()).append("any_publicacio", llibre.getAny_publicacio()).append("portada", llibre.getPortada()).append("lectors", llibre.getUsuaris());
		JSONObject doc1 = new JSONObject();
		doc1.put("dada", "llibre");
		doc1.put("titol", llibre.getTitol());
		doc1.put("autor", llibre.getAutor());
		doc1.put("genere", llibre.getGenere());
		doc1.put("descripcio", llibre.getDescripcio());
		doc1.put("any_publicacio", llibre.getAny_publicacio());
		doc1.put("portada", llibre.getPortada());
		doc1.put("lectors", llibre.getUsuaris());
		
		//InsertOneResult result = database.insertOne(doc1);
		
		
		
		 try {
			 
			 System.out.println("DOC1.TOSTRING: "+doc1.toString());
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://m6-uf-3-api-tau.vercel.app/add"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(doc1.toString()))
                    .build();

            CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
			try {
					TimeUnit.SECONDS.sleep(1); // Això ho posem per esperar a que s'enviin les dades
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            responseFuture.thenAccept(response -> {
    		

                String responseBody = response.body();
                
            }).exceptionally(e -> {
                e.printStackTrace();
                return null;
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		
		
	
		
	}

	public ArrayList<Llibre> listTitle(String cerca) {
		String titol, autor, genere, descripcio, portada;
		int any_publicacio;
		Llibre llibre;
		ArrayList<Llibre> llibresToReturn = new ArrayList<Llibre>();
		//Bson filter = Filters.regex("titol", "$"+cerca+"$");
		Bson filter = Filters.regex("titol", cerca);
		FindIterable<Document> resultats =database.find(filter);
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
//		String titol, autor, genere, descripcio, portada;
//		int any_publicacio;
//		Llibre llibre;
		ArrayList<Llibre> llibresToReturn = new ArrayList<Llibre>();
		
		
		///////////////////////////NOU CODI
		
		 try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://m6-uf-3-api-tau.vercel.app/list/"+resultatDates.get(0)+"/"+resultatDates.get(1)))
                    .GET()
                    .build();

           // CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            try {
//					TimeUnit.SECONDS.sleep(3); // Això ho posem per esperar a que s'enviin les dades
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
            //responseFuture.thenAccept(response -> {
    			String titol, autor, genere, descripcio, portada;
   			int any_publicacio;
   			Llibre llibre;

                String responseBody = response.body();
                //System.out.println(responseBody);
                //System.out.println(".........");

                // Parse JSON response manually
                JSONArray jsonArray = new JSONArray(responseBody);
                //jsonArray2 = jsonArray;
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    //User user = new User();
                    //user.setName(jsonObject.getString("name"));
                    //user.setEmail(jsonObject.getString("email"));
                    Document item = Document.parse( jsonObject.toString() );
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
//        			//System.out.println(lectors.size());
//        			//System.out.println(lectors.toString());
        			for (int j = 0; j < lectors.size(); j++)
        				{
        				Lector newLector = new Lector(lectors.get(j).getString("nom"));
        				newLector.addRessenya(lectors.get(j).getString("ressenya"));
        				llibre.addUsuari(newLector);
        				}
        			llibresToReturn.add(llibre);
                
//            }
//            }).exceptionally(e -> {
//                e.printStackTrace();
//                return null;
//            });
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		
		
		////////////////////////////// FI NOU CODI
		
		
		
		
		
		
//		//Bson filter = Filters.regex("titol", "$"+cerca+"$");
//		Bson filter = Filters.and(Filters.gte("any_publicacio",resultatDates.get(0) ),Filters.lte("any_publicacio",resultatDates.get(1)));
//		FindIterable<Document> resultats =database.find(filter);
//		MongoCursor<Document> cursor = resultats.iterator();
//		while (cursor.hasNext()) {
//			Document item = cursor.next();
//			//Document lectors;
//		    //System.out.println(cursor.next().toJson());
//			titol = item.getString("titol");
//			autor = item.getString("autor");
//			genere = item.getString("genere");
//			descripcio = item.getString("descripcio");
//			any_publicacio = item.getInteger("any_publicacio");
//			//any_publicacio = new Date();
//			portada = item.getString("portada");
//			//lectors = item.get(lectors);
//			llibre = new Llibre(titol, autor, genere, descripcio, any_publicacio, portada);
//			List<Document> lectors = (List<Document>) item.get("lectors");
//			//System.out.println(lectors.size());
//			//System.out.println(lectors.toString());
//			for (int j = 0; j < lectors.size(); j++)
//				{
//				Lector newLector = new Lector(lectors.get(j).getString("nom"));
//				newLector.addRessenya(lectors.get(j).getString("ressenya"));
//				llibre.addUsuari(newLector);
//				}
//			llibresToReturn.add(llibre);
//		}
		return llibresToReturn;
	}

	
}
