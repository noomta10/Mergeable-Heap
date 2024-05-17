package Maman13;
import static Maman13.Main.*;
import java.util.Scanner;


public class HeapOperations {
    /**
     * Create a heap from an array of numbers
     * @param array is the array of numbers from the file the user provided
     * @return the heap created 
     */
    public static Heap createHeap(int[] array) {
        Heap heap = new Heap();
        
        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }
    
        return heap;
    }
   
    
    /**
     * Bubble sort an array of numbers
     * @param array is the array of numbers from the file the user provided
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    

    /**
     * Create heap and display it
     * @param heap is the heap to insert the numbers from the file
     * @param listType sorted or not sorted
     * @return the heap created 
     */
    public static Heap makeHeap(Heap heap, String listType) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name for array input: ");
        String fileName = scanner.nextLine();
        int[] numbersArray = getInputFromFile(fileName);
    
        if (listType.equals("sorted")){
            bubbleSort(numbersArray);
        }
    
        heap = createHeap(numbersArray);
        
        System.out.println("Heap created:");
        heap.display();
    
        return heap;
    }
    
  
    /**
     * insert an element to heap and display the new heap
     * @param heap is the heap to insert the element 
     * @param listType sorted or not sorted
     */ 
    public static void insert(Heap heap, String listType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to insert: ");
        int numberToInsert = scanner.nextInt();
    
        if (listType.equals("sorted")){
           heap.addOrdered(numberToInsert);
        } else {
            heap.add(numberToInsert);
        }
    
        System.out.println("Heap after insertion:");
        heap.display();
    }
    

    /**
     * Find minimum element in the heap and delete it
     * @param heap is the heap to delete the minimum from
     * @param listType sorted or not sorted
     */
    public static void extractMin(Heap heap, String listType) {
        Node current = heap.head; 
        if (current == null){
            System.out.println("Heap empty, no minumum found\n");
            return;
        }
    
        if (listType.equals("sorted")){
            heap.deleteHead();
        } else {
            int min = current.data;
            while (current != null) {
                if (current.data < min) {
                    min = current.data;
                }
                current = current.next;
            }
            heap.delete(min);
        }
    
        System.out.println("Heap after deletion:");
        heap.display();
    }
    

    /**
     * Find minimum element in the heap and print it
     * @param heap is the heap to insert the numbers from the file
     * @param listType sorted or not sorted
     */
    public static void minimum(Heap heap, String listType) {
        Node current = heap.head; 
        if (current == null){
            System.out.println("Heap empty, no minumum found\n");
            return;
        }
    
        int min = current.data;
        if (listType.equals("not sorted")){
            while (current != null) {
                if (current.data < min) {
                    min = current.data;
                }
                current = current.next;
            }
        }
    
        System.out.printf("Heap minimum: %d\n", min);
    }
    

    /**
     * Union merge heap B to heap A 
     * @param heapA first heap
     * @param heapB second heap
     * @param listType sorted or not sorted
     */
    public static void union(Heap heapA, Heap heapB, String listType) {
        Node current = heapB.head; 
        
        System.out.println("Before UNION:\nHeap A: ");
        heapA.display();
        System.out.println("Heap B: ");
        heapB.display();
        
        while (current != null) {
            if (listType.equals("sorted")){
                heapA.addOrdered(current.data);
            } else {
                heapA.add(current.data);
            }
            heapB.delete(current.data);
            current = current.next;
        }
    
        System.out.println("After UNION:\nHeap A: ");
        heapA.display();
        System.out.println("Heap B: ");
        heapB.display();
    }   
}
