package data_structures;
import models.Task;

// DoublyLinkedList for bidirectional navigation of tasks within a category

public class DoublyLinkedList {

    private class Node {
        // same as singly, but add a 'prev' reference too
        Task data;
        Node next;
        Node prev;
        Node(Task data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;  // new! track the last node too
    private int size;

    // add to the end
    // hint: new node's prev points to current tail
    // tail's next points to new node
    // update tail to new node
    public void add(Task task) {
        Node temp = new Node(task);
        if(head == null){
            head = temp;
            tail = temp;
            size++;
            return;
        }
        // dont need to traverse in doubly like in singly
        temp.prev = tail; // new node points back to old tail
        tail.next = temp; // old tail points at new node
        tail = temp; // update tail with new node
        size++;
    }

    // remove by task ID
    // hint: when unlinking, update BOTH next and prev pointers
    // removed.prev.next = removed.next
    // removed.next.prev = removed.prev
    public void remove(int taskId) {
        if(head == null){
            return;
        }

        if(head.data.getId() == taskId){
            head = head.next;
            if(head != null){
                head.prev = null;
            } else{
                tail = null;
            }
            size--;
            return;
        }

        Node current = head;
        while(current != null){
            if(current.data.getId() == taskId){
                if(current.prev != null){
                    current.prev.next = current.next;
                }
                if(current.next != null){
                    current.next.prev = current.prev;
                }
                if(current == tail){
                    tail = current.prev;
                }
                size--;
                return;
            }
            current = current.next;

        }

    }

    // navigate forward from head to tail (same as singly)
    public void printForward() {
        Node current = head;

        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
        return;

    }

    // navigate backward from tail to head (this is the new power)
    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
        return;

    }

    public int size() {
        return size;
    }

    public Task get(int index) {
        // same logic as singly
        if(index < 0 || index >= size){
            return null;
        }
        Node current = head;
        for(int i =0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
}
