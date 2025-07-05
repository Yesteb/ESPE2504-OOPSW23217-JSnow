
package ec.edu.espe.jsnow.controller;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Yesteb JSnow
 */
public class DBController {

    private static final String URL = "mongodb+srv://esteban474sanchez:Yesteb@<cluster>.mongodb.net/?retryWrites=true&w=majority";
    private static final String nameDB = "JSnow";

    private static MongoDatabase database;

    private DBController(){}

    public static MongoDatabase getDatabase() {
        if (database == null) {
            MongoClient mongoClient = MongoClients.create(URL);
            database = mongoClient.getDatabase(nameDB);
        }
        return database;
    }
}


