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
    

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


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


    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty\n");
            return;
        }
        
        head = head.next;
    }


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
