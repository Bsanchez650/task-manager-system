package data_structures;
import models.Task;

// BST to organize tasks by due date

public class BST {

    private class Node {
        // what goes here? Think: data, left, right
        Task data;
        Node left;
        Node right;
        
        Node(Task data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void insert(Task task) {
        // add task based on dueDate comparison
        root = insertHelper(root ,task);
    }

    private Node insertHelper(Node node, Task task){
        if(node == null){
            return new Node(task);
        }

        if(task.getDuedate().compareTo(node.data.getDuedate()) < 0){
            node.left = insertHelper(node.left, task);
        } else {
            node.right = insertHelper(node.right, task);
        }

        return node;

    }

    public Task search(String dueDate) {
        // find a task by due date
        root = searchHelper(dueDate);
    }

    private Node searchHelper(String dueDate){
        if(root == null){
            return null;
        }

        if(root.data.getDuedate().equals(dueDate)){
            return root;
        }else if(roo){
        }
    }

    // three traversals — these matter for the project
    public void inOrder() {
        // left, root, right — gives tasks in sorted date order
    }

    public void preOrder() {
        // root, left, right
    }

    public void postOrder() {
        // left, right, root
    }
}