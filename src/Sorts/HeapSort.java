package Sorts;

import Trees.MaxHeap;
import Trees.MinHeap;
import org.jetbrains.annotations.NotNull;

/**
 * Heapsort will take an input array and convert it into a Min/Max heap. The elements will then be sorted
 * into an array in ascending or descending order.
 */
public class HeapSort {

    /**
     * Default constructor for HeapSort. The default sort order is Ascending.
     */
    public HeapSort(){}

    /**
     * Convert the input array into a MinHeap and then remove each element to sort the array.
     * @param inputArray An unsorted array of ints.
     */
    public void sortAscending(int[] inputArray){

        if(inputArray.length == 0){return;}

        MinHeap minHeap = new MinHeap();
        for (int j : inputArray) {
            minHeap.insert(j);
        }

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = minHeap.poll();
        }
    }

    /**
     * Convert the input array into a MaxHeap and then remove each element to sort the array.
     * @param inputArray An unsorted array of ints.
     */
    public void sortDescending(int [] inputArray){

        MaxHeap maxHeap = new MaxHeap();
        for (int j : inputArray) {
            maxHeap.insert(j);
        }

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = maxHeap.poll();
        }
    }
}
