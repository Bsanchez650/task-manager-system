package data_structures;
import models.Task;

// Queue for task scheduling (FIFO)

public class Queue {

    private class Node {
        // same as before
        Task data;
        Node next;
        Node(Task data){
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public void enqueue(Task task) {
        // add to rear
        Node temp = new Node(task);
        if(isEmpty()){
            front = temp;
            rear = temp;
            size++;
            return;
        }
        rear.next = temp;
        rear = temp;
        size++;
    }

    public Task dequeue() {
        // remove and return from front
        if(isEmpty()){return null;}
        Task x = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
        return x;

    }

    public Task peek() {
        // look at front without removing
        if(isEmpty()){return null;}
        return front.data;
    }

    public boolean isEmpty() {
        // check if empty
        return size == 0;
    }

    public int size() {
        return size;
    }
}