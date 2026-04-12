package data_structures;
import models.Task;

//SinglyLinkedList to handle my task history

public class SinglyLinkedList {

    private class Node{
        Task data;
        Node next;
        
        public Node(Task data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public void add(Task task){
        Node temp = new Node(task);
        if(head == null){
            head = temp;
            size++;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = current;
        size++;
    }

    public void remove(int taskId){
        if(head == null){
            return;
        }

        if(taskId == head.data.getId()){
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while(current.next != null){
            if(taskId == current.next.data.getId()){
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void print(){
        Node current = head;
        
        while(current != null){
            System.out.println(current.data);
            current = current.next;

        }
        return;
    }

    public int size(){
        return size;
    }

    public Task get(int index){
        if(index < 0 || index >= size){
            return null;
        }

        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        return current.data;
    }

}
