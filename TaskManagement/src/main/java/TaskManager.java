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
        boolean found = checkTask(title);
        if (found) {
            //Check if creating duplicate
            System.out.println("A task with this title already exists.");
        } else {
            Document task = new Document("title", title).append("desc", desc).append("status", "Incomplete");
            col.insertOne(task);
            System.out.println("Task has been successfully created!");
        }

    }
    //Remove tasks, deleteOne allows us to delete a specific task
    public void RemoveTask(String title) {
        MongoCollection<Document> col = db.getCollection("Tasks");
        boolean found = checkTask(title);
        if(found) {
            //Check if this task exists
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
            String status = document.getString("status");
            System.out.println("\n------------------"
                    + "\nTask Name: "
                    + title
                    + "\nTask Description: "
                    + desc
                    + "\nTask Status: "
                    + status
                    + "\n------------------");
        }
    }
    //Be able to check the status of certain tasks to be completed when done
    public void CompleteTask(String title) {
        MongoCollection<Document> col = db.getCollection("Tasks");
        boolean found = checkTask(title);
        if (found) {
            col.updateOne(new Document("title", title), new Document("$set", new Document("status", "Complete")));
            System.out.println("Task has been completed\n");
        } else {
            System.out.println("Task was not found\n");
        }
    }
    public boolean checkTask(String title) {
        MongoCollection<Document> col = db.getCollection("Tasks");
        Document retrieve = new Document("title", title);
        Document doc = col.find(retrieve).first();
        return doc != null;
    }

}
