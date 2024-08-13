import com.mongodb.client.*;
import org.bson.Document;

public class MongoConnect {

    public static MongoDatabase getDatabase() {

        MongoClient mongoDB = MongoClients.create("mongodb+srv://motiwalasafeer:Galide1120@tms.emsma.mongodb.net/?retryWrites=true&w=majority&appName=TMS");
        MongoDatabase db = mongoDB.getDatabase("Tasks");
        return db;
    }
}
