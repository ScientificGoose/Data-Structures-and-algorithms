package Sorts;

/**
 * Quick sort is a divide and conquer sorting algorithm. The input array is divided into sub arrays by selecting a
 * pivot point. Once a pivot is selected the elements of the array are organized so the elements that are less than
 * the pivot's value are moved to the left of the pivot, the larger elements are moved to the right.
 *
 * The array is subdivided until each sub array contains only a single element. At this point the array is sorted.
 */
public class QuickSort {

    /**
     * Default constructor.
     */
    public QuickSort(){}

    /**
     * Partition will organize the elements of the input array so all elements smaller than the pivot are on the left
     * of the pivot and all larger elements are on the right of the pivot.
     * @param inputArray An unsorted array of ints.
     * @param left The left index for the sub array.
     * @param right The right index for the sub array.
     * @return The index value for the partition.
     */
    private int partition(int[] inputArray, int left, int right){

        // Choose the right most element as the pivot.
        int pivot = inputArray[right];

        // Create a pointer the element greater than the pivot.
        int pointer = left;

        // Perform a linear traversal on the input array and compare each element with the pivot.
        for(int i = left; i < right; i++) {
            // If an element smaller than the pivot is found, swap with the pointer.
            if (inputArray[i] <= pivot) {
                swap(inputArray, pointer++, i);
            }
        }

        // Swap the pivot with the pointer.
        swap(inputArray, pointer, right);
        return pointer;
    }

    /**
     * Sort will find the partition for the input array and recursively call QuickSort on the sub array.
     * @param inputArray An unsorted array of ints.
     * @param left The left index for the sub array.
     * @param right The right index for the sub array.
     */
    public void sort(int[] inputArray, int left, int right){
        // If the sub array is only a single element.
        if(left > right){return;}

        // Find the partition of the input array.
        int partition = partition(inputArray, left, right);

        // Call sort on the left sub array.
        sort(inputArray, left, partition - 1);

        // Call sort on the right sub array.
        sort(inputArray, partition + 1, right);
    }

    /**
     * Swap will switch the location of two elements in the input array.
     * @param inputArray An array of ints.
     * @param firstIndex The index of the first element to be swapped.
     * @param secondIndex The index of the second element to be swapped.
     */
    private void swap(int[] inputArray, int firstIndex, int secondIndex){

        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp;
    }
}
