
import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] array){
        int n = array.length;

        // Build a min heap
        Heap minHeap = new Heap(n);
        for(int i = 0; i < n; i++){
            minHeap.insert(array[i]);
        }

        // Extract elements from the min heap in ascending order to sort the array
        for(int i = 0; i < n; i++){
            array[i] = minHeap.removeMin();
        }
    }

    public static void main(String[] args){
        // Test case 1
        int[] array1 = {-12387, 5, 0, 1, 1082371283, -1923612};
        System.out.println("Unsorted array: " + Arrays.toString(array1));

        HeapSort.heapSort(array1);
        System.out.println("Sorted array: " + Arrays.toString(array1));
        System.out.println();

        // Test case 2
        int[] array2 = {9, 2, 8, 1, 7, 3, 6, 4, 5};
        System.out.println("Unsorted array: " + Arrays.toString(array2));

        HeapSort.heapSort(array2);
        System.out.println("Sorted array: " + Arrays.toString(array2));
    }
}