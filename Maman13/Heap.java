package Maman13;
import java.util.*;


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class Heap {
    Node head;

    
    public Heap() {
        this.head = null;
    }


    /**
     * Add element to heap
     * @param data data of the node to add
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    /**
     * Add element to its appropriate place in ordered heap
     * @param data data of the node to add
     */
    public void addOrdered(int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    

    /**
     * Print heap
     */
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    /**
     * Delete node from the heap
     * @param data data of the node to delete
     */
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty\n");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Data not found in the list");
    }


     /**
     * Delete first node from the heap
     */
    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty\n");
            return;
        }
        
        head = head.next;
    }


     /**
     * Sort heap with priority queue implementation 
     */
    public void heapSort() {
        if (head == null || head.next == null)
            return;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Node current = head;
        while (current != null) {
            minHeap.offer(current.data);
            current = current.next;
        }

        current = head;
        while (!minHeap.isEmpty()) {
            current.data = minHeap.poll();
            current = current.next;
        }
    }
}
