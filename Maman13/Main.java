package Maman13;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import static Maman13.HeapOperations.*;


public class Main {
    /**
     * Get file name from user. exit if file is empty or not found
     * @param fileName file name the user entered
     * @return array with numbers from file
     */
    public static int[] getInputFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(new FileReader(fileName));
            String line = bufferReader.readLine(); 

            if (line != null) {
                String[] numbersString = line.trim().split("\\s+");
                int[] numbers = new int[numbersString.length];
                
                for (int i = 0; i < numbersString.length; i++) {
                    numbers[i] = Integer.parseInt(numbersString[i]); 
                }

            bufferReader.close();
            fileReader.close();
            return numbers;
                
            } else {
                System.out.println("Error: file empty\n");
                bufferReader.close();
                fileReader.close();
                System.exit(-1);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found\n");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error: can not read file\n");
            e.printStackTrace();
        }
            return null;
    }


    /**
     * Display menu to the user
     * @param listType sorted or not sorted
     * @param heapA first heap
     * @param heapB second heap
     */
    public static void displayMenu(String listType, Heap heapA, Heap heapB) {
        Scanner scanner = new Scanner(System.in);
        int operationNumber;

        do {
            System.out.print("\nEnter desired operation:\n1. MAKE-HEAP A\n2. MAKE-HEAP B\n3. INSERT A\n4. INSERT B\n" +
                             "5. MINIMUM A\n6. MINIMUM B\n7. EXTRACT MIN A\n8. EXTRACT MIN B\n9. UNION\n10. SORT A\n11. SORT B\n12. EXIT\n");
            operationNumber = scanner.nextInt();

            switch (operationNumber) {
                case 1:
                    heapA = makeHeap(heapA, listType);
                    break;
                case 2:
                    heapB = makeHeap(heapB, listType);
                    break;
                case 3:
                    insert(heapA, listType);
                    break;
                case 4:
                    insert(heapB, listType);
                    break;
                case 5:
                    minimum(heapA, listType);
                    break;
                case 6:
                    minimum(heapB, listType);
                    break;
                case 7:
                    extractMin(heapA, listType);
                    break;
                case 8:
                    extractMin(heapB, listType);
                    break;
                case 9:
                    union(heapA, heapB, listType);
                    break;
                case 10:
                    heapA.heapSort();
                    heapA.display();
                    break;
                case 11:
                    heapB.heapSort();
                    heapB.display();
                case 12:
                    break;
                default:
                    System.out.println("Error: operation number must be a number between 1 and 10\n");
                    break;
            }
        } while (operationNumber != 12);
    }


    /**
     * Get list type from the user
     * @return list type sorted or not sorted
     */
    public static String getListType() {
        Scanner scanner = new Scanner(System.in);
        String listType;

        do {
            System.out.print("Enter array type (sorted or not sorted): ");
            listType = scanner.nextLine();
            switch (listType) {
                case "sorted":
                    break;
                case "not sorted":
                    break;
                default:
                    System.out.println("Error: list type should be 'sorted' or 'not sorted'\n");
                    break;
            };
        } while (!listType.equals("sorted") && !listType.equals("not sorted"));

        return listType;
    }



    /**
     * Create 2 empty heaps and display an interactive menu with operations to the user
     */
    public static void main(String[] args) {
        int[] emptyArray = new int[0];
        Heap heapA = createHeap(emptyArray);
        Heap heapB = createHeap(emptyArray);
        String listType = getListType();
        displayMenu(listType, heapA, heapB);
    }
}