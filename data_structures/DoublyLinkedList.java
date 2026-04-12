package data_structures;
import models.Task;

// DoublyLinkedList for bidirectional navigation of tasks within a category

public class DoublyLinkedList {

    private class Node {
        // same as singly, but add a 'prev' reference too
    }

    private Node head;
    private Node tail;  // new! track the last node too
    private int size;

    // add to the end
    // hint: new node's prev points to current tail
    // tail's next points to new node
    // update tail to new node
    public void add(Task task) {

    }

    // remove by task ID
    // hint: when unlinking, update BOTH next and prev pointers
    // removed.prev.next = removed.next
    // removed.next.prev = removed.prev
    public void remove(int taskId) {

    }

    // navigate forward from head to tail (same as singly)
    public void printForward() {

    }

    // navigate backward from tail to head (this is the new power)
    public void printBackward() {

    }

    public int size() {
        return size;
    }

    public Task get(int index) {
        // same logic as singly
    }
}
