import managers.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        GraphManager gm = new GraphManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Undo");
            System.out.println("5. Redo");
            System.out.println("6. Search by Id");
            System.out.println("7. View History");
            System.out.println("8. Schedule Next");
            System.out.println("9. Add Dependency");
            System.out.println("10. View Dependencies (DFS)");
            System.out.println("11. View Dependencies (BFS)");
            System.out.println("12. Check Circular Dependencies");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                // fill in each case
                case 1: 
                    System.out.println("Add Task: enter name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter priority: ");
                    int priority = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter due date(format: yyyy/mm/dd): ");
                    String dueDate = scanner.nextLine();
                    
                    tm.addTask(name, priority, dueDate);
                    gm.addTask(tm.getNextId()-1);
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.println("Delete");
                    System.out.println("Enter Delete id: ");
                    int id = scanner.nextInt();
                    tm.deleteTask(id);
                    System.out.println("Task deleted");
                    break;
                
                case 3:
                    System.out.println("Printing all task");
                    tm.viewAllTasks();
                    break;
                case 4:
                    System.out.println("Undo: ");
                    tm.undo();
                    break;

                case 5:
                    System.out.println("Redo: ");
                    tm.redo();
                    break;

                case 6:
                    System.out.println("Enter Search id: ");
                    int Searchid = scanner.nextInt();
                    tm.searchById(Searchid);
                    break;
                case 7:
                    System.out.println("History: ");
                    tm.viewHistory();
                    break;
                case 8:
                    System.out.println("Schedule next: ");
                    tm.scheduleNext();
                    break;
                case 9:
                    System.out.println("add Dependencies: ");
                    System.out.println("Enter id from: ");
                    int fromId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter toId: ");
                    int toId = scanner.nextInt();
                    gm.addDependency(fromId, toId);
                    break;
                case 10:
                    System.out.println("View Dependencies (DFS)");
                    System.out.println("Enter id: ");
                    int id2 = scanner.nextInt();
                    gm.viewDependenciesDFS(id2);
                    break;
                
                case 11:
                    System.out.println("View Dependencies (BFS)");
                    System.out.println("Enter id: ");
                    int id3 = scanner.nextInt();
                    gm.viewDependenciesBFS(id3);
                    break;
                
                case 12:
                    if(gm.hasCycle()){
                        System.out.println("Circular dependency detected!");
                    } else {
                        System.out.println("No Circular dependencies");
                    }
                    break;
                
                case 0:
                    System.out.println("goodbye");
                    running = false;
                    break;



            }
        }
    }
}