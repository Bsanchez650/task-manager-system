package data_structures;
import models.Task;

// CircularLinkedList to manage recurring tasks

public class CircularLinkedList {

    private class Node {
        // same as singly
        Task data;
        Node next;

        Node(Task data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;  // tail.next always points back to head
    private int size;

    // add to the end
    // hint: after adding, make sure tail.next = head
    public void add(Task task) {
        Node temp = new Node(task);
        if(head == null){
            head = temp;
            tail = temp;
            tail.next = head;
            size++;
            return;
        }
        tail.next = temp;
        tail = temp;
        tail.next = head;
        size++;
        return;

    }

    // remove by task ID
    // hint: same as singly, but the last node points to head, not null
    // so check current.next != head instead of current.next != null
    public void remove(int taskId) {
        if(head == null){
            return;
        }

        if(head.data.getId() == taskId){
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = head.next;
                tail.next = head;//this line makes the loop
            }
            size--;
            return;
        }

        Node current = head;
        while(current.next != head){
            if(current.next.data.getId() == taskId){
                if(current.next == tail){
                    tail = current;//if we remove the last node then we update tail
                }
                current.next = current.next.next;//same as singly
                tail.next = head; //this line keeps the loop
                size--;
                return;
            }
            current = current.next;
        }

    }

    // print all tasks once (stop when you loop back to head)
    public void print() {
        if(head == null){
            return;
        }
        Node current = head;
        do {
            System.out.println(current.data);
            current = current.next;
        }
        while(current != head);

    }

    public int size() {
        return size;
    }
}