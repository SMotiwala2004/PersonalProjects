import com.mongodb.client.*;
import org.bson.Document;

public class MongoConnect {

    public static MongoDatabase getDatabase() {
        //Connect database
        MongoClient mongoDB = MongoClients.create("");
        MongoDatabase db = mongoDB.getDatabase("Tasks");
        return db;
    }
}
