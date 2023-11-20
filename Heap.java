
import java.util.NoSuchElementException;

public class Heap {
    private int[] H;
    private int size;
    private int capacity;

    public Heap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.H = new int[capacity + 1];
    }

    private int parent(int i){
        return(i/2);
    }

    private int left(int i){
        return(2*i);
    }

    private int right(int i){
        return(2*i + 1);
    }

    private void swap(int i, int j){
        int temp = H[i];
        H[i] = H[j];
        H[j] = temp;
    }

    public void insert(int value){
        if(size == capacity){
            throw new NoSuchElementException("Heap is full");
        }

        size ++;
        H[size] = value;
        upHeap(size);
    }

    public int removeMin(){
        if(size == 0){
            throw new NoSuchElementException("Heap is empty");
        }

        int min = H[1];
        H[1] = H[size];
        size--;
        downHeap(1);

        return(min);
    }

    private void upHeap(int i){
        while ((i > 1) && (H[i] < H[parent(i)])){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void downHeap(int i){
        int minIndex = i;
        int left = left(i);
        int right = right(i);

        if((left <= size) && (H[left] < H[minIndex])){
            minIndex = left;
        }

        if((right <= size) && (H[right] < H[minIndex])){
            minIndex = right;
        }

        if(i != minIndex){
            swap(i, minIndex);
            downHeap(minIndex);
        }
    }

    public boolean isEmpty(){
        return(size == 0);
    }

    public int size(){
        return(size);
    }

    public int min(){
        return(H[1]);
    }
}