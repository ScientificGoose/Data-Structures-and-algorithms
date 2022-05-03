package Trees;

import java.util.Arrays;

public class MaxHeap {

    private int[] array;
    private int capacity = 10;
    private int size;

    /**
     * This is the default constructor for MaxHeap.
     */
    public MaxHeap(){

        this.size = 0;
        array = new int[capacity];
    }

    // Get node index numbers.
    private int getLeftChildIndex(int parentIndex) {return (2 * parentIndex) + 1;}
    private int getRightChildIndex(int parentIndex) {return (2 * parentIndex) + 2;}
    private int getParentIndex(int childIndex) {return (childIndex - 1) / 2;}

    // Check if nodes exist.
    private boolean hasLeftChild(int index) {return getLeftChildIndex(index) < size;}
    private boolean hasRightChild(int index) {return getRightChildIndex(index) < size;}
    private boolean hasParent(int index) {return getParentIndex(index) >= 0;}

    // Retrieve node values.
    private int leftChild(int index) {return array[getLeftChildIndex(index)];}
    private int rightChild(int index) {return array[getRightChildIndex(index)];}
    private int parent(int index) {return array[getParentIndex(index)];}

    /**
     * This method will resize the array if it has reached capacity.
     */
    private void ensureSpace(){
        if(array.length == capacity){
            array = Arrays.copyOf(array, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * This method returns the size of the heap.
     * @return An int value for the size of the heap.
     */
    public int getSize(){return size;}

    /**
     * This method will return the sorted array with empty index values removed.
     * @return The array for the sorted heap.
     */
    public int[] getArray(){
        int[] temp = new int[size];
        System.arraycopy(array, 0, temp, 0,size);
        return temp;
    }

    /**
     * This method will insert a new element into the heap.
     * @param element An int element to be entered.
     */
    public void insert(int element){
        ensureSpace();
        array[size++] = element;
        heapifyUp();
    }

    /**
     * This method will return the largest value in the heap, if it exists.
     * @return The largest value in the heap.
     */
    public int peek(){
        if(size == 0) throw new IllegalStateException();
        return array[0];
    }

    /**
     * This method will return the largest value in the heap and then remove it from the heap.
     * @return The largest value in the heap.
     */
    public int poll(){
        if(size == 0) throw new IllegalStateException();
        int element = array[0];
        array[0] = array[size - 1];
        size--;
        heapifyDown();
        return element;
    }

    /**
     * This method will swap two elements in the array.
     * @param firstIdx The index of the first element to be swapped.
     * @param secondIdx The index of the second element to be swapped.
     */
    private void swap(int firstIdx, int secondIdx){

        int temp;
        temp = this.array[firstIdx];
        this.array[firstIdx] = this.array[secondIdx];
        this.array[secondIdx] = temp;
    }

    /**
     * This method will sort the heap from the leaf nodes to the root.
     */
    public void heapifyUp(){
        int index = size - 1;
        while(hasParent(index) && parent(index) < array[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * This method will sort the heap from the root to the leaf nodes.
     */
    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)) {
            int LargestChild = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)){
                LargestChild = getRightChildIndex(index);
            }
            if(array[index] > array[LargestChild]){
                break;
            } else {
                swap(index, LargestChild);
            }
            index = LargestChild;
        }
    }
}
