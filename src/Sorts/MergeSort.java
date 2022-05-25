package Sorts;

/**
 * MergeSort is a recursive sorting algorithm. The input array is continually split until it reaches
 * a size of 1. The stack is then propagated and sorted into ascending order.
 */
public class MergeSort {

    /**
     * Default constructor.
     */
    public MergeSort(){}

    /**
     * This method merges the arrays into ascending sorted order.
     * @param inputArray An int array to be merged.
     * @param left the left index to be used to create a sub array.
     * @param mid The midpoint index to be used to create a sub array.
     * @param right The right index to be used to create a sub array.
     */
    private void merge(int[] inputArray, int left, int mid, int right){

        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];


        // Create a sub array with the left half of the input array.
        for(int i = 0; i < leftSize; i++){
            leftArray[i] = inputArray[left + 1];
        }
        // Create a sub array with the right half of the input array.
        for(int i = 0; i < rightSize; i++){
            rightArray[i] = inputArray[mid + 1 + i];
        }

        // Initialize iterators.
        int i = 0;
        int j = 0;
        int k = left;

        // Sort elements of the left and right sub arrays
        while(i < leftSize && j < rightSize){
            if(leftArray[i] <= rightArray[j]){
                inputArray[k++] = leftArray[i++];
            } else{
                inputArray[k++] = rightArray[j++];
            }
        }

        // Add any remaining elements from the left sub array to the main array.
        while(i < leftSize){
            inputArray[k++] = leftArray[i++];
        }

        // Add any remaining elements from the right sub array to the main array.
        while(j < rightSize){
            inputArray[k++] = rightArray[j++];
        }
    }

    /**
     * The sort method will recursively split the input array into left and right sub arrays.
     * @param inputArray An array of integers.
     * @param left The left index for the sub array.
     * @param right The right index for the sub array.
     */
    public void sort(int[] inputArray, int left, int right){

        int midpoint = left + (right - 1)/2;

        sort(inputArray, left, midpoint);
        sort(inputArray, midpoint + 1, right);

        merge(inputArray, left, midpoint, right);
    }
}
