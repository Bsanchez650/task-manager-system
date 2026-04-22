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
        // find a task by due date]
        Node result = searchHelper(root, dueDate);
        return result != null ? result.data : null;
    }

    private Node searchHelper(Node node, String dueDate){
        if(node == null){
            return null;
        }

        if(node.data.getDuedate().equals(dueDate)){
            return node;
        }else if(dueDate.compareTo(node.data.getDuedate()) < 0){
            return searchHelper(node.left, dueDate);
        }else{
            return searchHelper(node.right, dueDate);
        }
    }

    // three traversals — these matter for the project
    public void inOrder() {
        // left, root, right — gives tasks in sorted date order
       inOrderHelper(root);
    }

    private void inOrderHelper(Node node){
         if(node == null){
            return;
        }
        inOrderHelper(node.left);
        System.out.println(node.data);
        inOrderHelper(node.right);
    }

    public void preOrder() {
        // root, left, right
        preOrderHelper(root);
    }

    private void preOrderHelper(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }

    public void postOrder() {
        // left, right, root
        postOrderHelper(root);
    }

    private void postOrderHelper(Node node){
        if(node == null){
            return;
        }

        postOrderHelper(node.left);
        postOrderHelper(node.right);
        System.out.println(node.data);
    }

}