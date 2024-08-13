import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TaskManager {
    private MongoDatabase db;

    public TaskManager() {
        this.db = MongoConnect.getDatabase();
    }

    public void AddTask(String title, String desc) {
        MongoCollection<Document> col = db.getCollection("Tasks");
        Document task = new Document("title", title).append("desc", desc).append("status", "Incomplete");
        col.insertOne(task);

    }
    //Remove tasks, deleteOne allows us to delete a specific task
    public void RemoveTask(String title) {
        MongoCollection<Document> col = db.getCollection("Tasks");
        boolean found = checkTask(title);
        if(found) {
            col.deleteOne(new Document("title", title));
            System.out.println("Task has been sucessfully removed");
        } else {
            System.out.println("Could not find the entered task");
        }
    }
    //List tasks by using a for each loop and going through each document in the collection and printing it
    public void ListTask() {
        MongoCollection<Document> col = db.getCollection("Tasks");
        for(Document document : col.find()) {
            String title = document.getString("title");
            String desc = document.getString("desc");
            System.out.println("\n------------------"
                    + "\nTask Name: "
                    + title
                    + "\nTask Description: "
                    + desc
                    + "\n------------------");
        }
    }
    //Be able to check the status of certain tasks to be completed when done
    public void CompleteTask(String title) {
        MongoCollection<Document> col = db.getCollection("Tasks");
        col.updateOne(new Document("title", title), new Document("$set", new Document("status", "Complete")));
        RemoveTask(title);
    }
    public boolean checkTask(String title) {
        MongoCollection<Document> col = db.getCollection("Tasks");
        Document retrieve = new Document("title", title);
        Document doc = col.find(retrieve).first();
        return doc != null;
    }

}
