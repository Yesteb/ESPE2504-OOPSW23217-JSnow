
package ec.edu.espe.jsnow.controller;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Yesteb JSnow
 */
public class DBController {

    private static final String URL = "mongodb+srv://username:password@cluster0.rpbnucr.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String nameDB = "databaseName";
    private static MongoCollection<Document> collection;

    private static MongoDatabase database;

    public DBController(){}

    public static MongoCollection<Document> getCollection(String nameCollection) {
    if (database == null) {
        MongoClient mongoClient = MongoClients.create(URL);
        database = mongoClient.getDatabase(nameDB);
    }
    return database.getCollection(nameCollection);
}
    

    public void insert(Document doc){
        MongoClient mongoClient = MongoClients.create(URL);
        database = mongoClient.getDatabase(nameDB);
        
    }
    

    public Document find(String id) {
        return collection.find(new Document("id", new ObjectId(id))).first();
    }
    

    public List<Document> findAll(){
        List<Document> docs = new ArrayList<>();
        collection.find().into(docs);
        
        return docs;
    }
    

    public void update(String id, Document updateInformation){
        collection.updateOne(
                new Document("id", new ObjectId(id)), 
                new Document("$set", updateInformation)
        ); 
    }
    

    public void delete(String id) {
        collection.deleteOne(new Document("id", new ObjectId(id)));
    }
    
    
}


