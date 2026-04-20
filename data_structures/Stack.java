package data_structures;
import models.Task;

// Stack for undo/redo functionality

public class Stack {

    private class Node {
        // what goes here?
        Task data;
        Node next;

        Node(Task data){
            this.data = data;
            this.next = null;
        }
    }

    private Node top;
    private int size;

    public void push(Task task) {
        // add to top
        Node temp = new Node(task);
        temp.next = top;
        top = temp;
        size++;

    }

    public Task pop() {
        // remove and return top
        if(isEmpty()){
            return null;
        }

        Task x = top.data;
        top = top.next;
        size--;
        return x;
    }

    public Task peek() {
        // return top without removing
        if(isEmpty()){
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        // check if empty
        return size ==0;
    }

    public int size() {
        return size;
    }
}