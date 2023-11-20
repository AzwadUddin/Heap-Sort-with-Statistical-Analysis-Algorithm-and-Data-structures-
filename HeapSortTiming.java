import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSortTiming {

    public static void main(String[] args) {
       // Define array sizes to test, including 2^20
       int[] arraySizes = {8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576};

       try {
           // Create FileWriter and BufferedWriter
           FileWriter fileWriter = new FileWriter("HeapSortResults.txt");
           BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

           // Write the header
           bufferedWriter.write("Size Time");
           bufferedWriter.newLine();

           for (int size : arraySizes) {
               // Generate an array of random integers
               int[] array = generateRandomArray(size);

               // Record the start time
               long startTime = System.nanoTime();

               // Sort array using Heap-Sort
               heapSort(array);

               // Record the end time
               long endTime = System.nanoTime();

               // Calculate the CPU time taken in milliseconds
               double cpuTime = (endTime - startTime) / 1e6; // Convert to milliseconds

               // Output the results
               String result = size + " " + cpuTime;
               System.out.println(result);

               // Write the result to the text file
               bufferedWriter.write(result);
               bufferedWriter.newLine();
           }

           // Close the BufferedWriter
           bufferedWriter.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    // Function to generate an array of random integers
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000); // Adjust range as needed
        }
        return array;
    }

    // Heap-Sort algorithm
    private static void heapSort(int[] array) {
        int n = array.length;

        // Build a max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Heapify the reduced heap
            heapify(array, i, 0);
        }
    }

    // Helper function to heapify a subtree with root at index i
    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Find the largest element among root, left child, and right child
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If the largest element is not the root, swap and continue heapifying
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(array, n, largest);
        }
    }
}
