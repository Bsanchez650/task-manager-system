package models;
import java.util.ArrayList;

public class Task{
    private int id;
    private String name;
    private int priority;
    private String dueDate;
    private ArrayList<Integer> dependencies;
    public Task(int id, String name, int priority, String dueDate){
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.dependencies = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public String getDuedate(){
        return dueDate;
    }

    public void setDuedate(String dueDate){
        this.dueDate = dueDate;
    }

    public String toString(){
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", dueDate='" + dueDate + '\'' +
                '}';
    }

    public ArrayList<Integer> getDependencies(){
        return dependencies;
    }

    public void addDependency(int taskId){
        dependencies.add(taskId);
    }


}