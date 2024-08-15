import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskApp {
    static Scanner sc = new Scanner(System.in);
    static TaskManager TM = new TaskManager();
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        System.out.println("Welcome back to TMS, What would you like to do today?");
        while(true) {
            System.out.println("|---------MainMenu---------|");
            System.out.println("1) Add Tasks\n" +
                    "2) Remove Tasks\n" +
                    "3) List Tasks\n" +
                    "4) Complete Task\n" +
                    "5) Exit Program");
            String UserInput = sc.nextLine();
            switch (UserInput){
                case "1":
                    //Access AddTaskUI
                    AddTaskUI();
                    break;
                case "2":
                    //Access RemoveTaskUI
                    RemoveTaskUI();
                    break;
                case "3":
                    //Access ListTaskUI
                    ListTaskMenu();
                    break;
                case "4":
                    //AccessStatusUI
                    StatusMenu();
                    break;
                case "5":
                    //Exit Program
                    System.out.print("Exiting Program");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice. Please try again!");
            }
       }

    }
    private static void AddTaskUI() {
        System.out.println("1) Add Task\n" +
                "2) Back to Main Menu");
        String UserInput = sc.nextLine();
        if(UserInput.equals("1")) {
            System.out.println("Enter the task name");
            String taskName = sc.nextLine();
            System.out.println("Enter the task description");
            String taskDesc = sc.nextLine();
            TM.AddTask(taskName, taskDesc);
            System.out.println("\n");
        } else if(UserInput.equals("2")) {
            System.out.println("\n");
            MainMenu();
        } else {
            System.out.println("Invalid Input\n");
            AddTaskUI();
        }
    }

    private static void RemoveTaskUI() {
        System.out.println("1) Remove Task\n" +
                "2) Back to Main Menu");
        String UserInput = sc.nextLine();
        if(UserInput.equals("1")) {
            TM.ListTask();
            System.out.println("Enter the task name you would like to remove");
            String taskName = sc.nextLine();
                TM.RemoveTask(taskName);
                System.out.println("\n");
        } else if (UserInput.equals("2")) {
            System.out.println("\n");
            MainMenu();
        } else {
            System.out.println("Invalid Input\n");
            RemoveTaskUI();
        }
    }

    private static void ListTaskMenu() {
        System.out.println("All remaining tasks");
        TM.ListTask();
        System.out.println("\n");
    }

    private static void StatusMenu() {
        System.out.println("1) Complete Task\n" +
                "2) Back to Main Menu");
        String UserInput = sc.nextLine();
        if (UserInput.equals("1")) {
            System.out.println("Remaining Tasks");
            TM.ListTask();
            System.out.println("Which task would you like to complete?");
            String taskName = sc.nextLine();
            TM.CompleteTask(taskName);
        } else if (UserInput.equals("2")) {
            System.out.println("\n");
            MainMenu();
        } else {
            System.out.println("Invalid Input");
            StatusMenu();
        }
    }

}
