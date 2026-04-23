package managers;
import models.Task;
import data_structures.*;
import java.util.*;



public class TaskManager {

    private HashMap<Integer, Task> tasks;        // all tasks by ID
    private SinglyLinkedList taskHistory;         // history log
    private data_structures.Stack undoStack;                      // undo
    private data_structures.Stack redoStack;                      // redo
    private data_structures.Queue taskQueue;                      // scheduling
    private BST taskTree;                         // search by date
    private int nextId;                           // auto-increment ID

    public TaskManager() {
        // initialize everything
        this.tasks = new HashMap<>();
        this.taskHistory = new SinglyLinkedList();
        this.undoStack = new data_structures.Stack();
        this.redoStack = new data_structures.Stack();
        this.taskQueue = new data_structures.Queue();
        this.taskTree = new BST();
        this.nextId = 1;
    }

    public void addTask(String name, int priority, String dueDate) {
        // create task, add to all structures
        Task task = new Task(nextId, name, priority, dueDate);
        tasks.put(nextId,task);
        taskHistory.add(task);
        taskQueue.enqueue(task);
        taskTree.insert(task);
        nextId++;
    }

    public void deleteTask(int taskId) {
        // remove from structures, push to undo stack
        Task task = tasks.get(taskId);
        if(task == null ){
            return;
        }
        undoStack.push(task);
        taskHistory.remove(taskId);
        tasks.remove(taskId);
    }

    public void undo() {
        // pop from undo, restore the task, push to redo
        if(undoStack.isEmpty()){
            return;
        }
        Task task = undoStack.pop();
        tasks.put(task.getId(), task);
        taskHistory.add(task);
        redoStack.push(task);

    }

    public void redo() {
        // pop from redo, delete again, push to undo
        if(redoStack.isEmpty()){
            return;
        }
        Task task = redoStack.pop();
        tasks.remove(task.getId());
        taskHistory.remove(task.getId());
        undoStack.push(task);
    }

    public void viewAllTasks() {
        // print all tasks
        for(Task task : tasks.values()){
            System.out.println(task);
        }
    }

    public void searchByDate(String dueDate) {
        // use BST to find
        Task task = taskTree.search(dueDate);
        if(task != null){
            System.out.println(task);
        }else{
            System.out.println("No task found for date: " + dueDate);
        }
    }

    public void searchById(int taskId) {
        Task task = tasks.get(taskId);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found");
        }
    }

    public void viewHistory() {
        // print task history
        taskHistory.print();
    }

    public void scheduleNext() {
        // dequeue next task from queue
        if(taskQueue.isEmpty()){
            System.out.println("No Tasks scheduled");
            return;
        }
        System.out.println("Next task: " + taskQueue.dequeue());
    }

    public int getNextId() {
        return nextId;
    }
}