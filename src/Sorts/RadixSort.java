package Sorts;

public class RadixSort{

    public RadixSort(){}

    /**
     * Find the largest element in the array.
     * @param array An array of integers.
     * @param length The length of the input array.
     * @return The largest element in the array.
     */
    private int getMax(int[] array, int length){

        int max = 0;
        for (int i = 0; i < length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Counting sort is a stable, non-comparative sorting algorithm.
     * @param inputArray An unsorted array of integers.
     * @param length The length of the input array.
     * @param place The place (1s, 10s, 100s, etc.) in base 10.
     */
    private void countingSort(int[] inputArray, int length, int place){

        int[] outputArray = new int[length + 10];
        int[] bucketArray = new int[10];

        // Count the number of occurrences of each element.
        for (int i = 0; i < length; i++) {
            bucketArray[(inputArray[i] / place) % 10]++;
        }

        // Count cumulative frequency of the elements.
        for (int i = 1; i < 10; i++){
            bucketArray[i] += bucketArray[i - 1];
        }

        // Place elements in the output array in sorted order.
        for (int i = length - 1; i >= 0; i--){
            outputArray[bucketArray[(inputArray[i] / place) % 10] - 1] = inputArray[i];
            bucketArray[(inputArray[i] / place) % 10]--;
        }
        
        // Place sorted elements into the input array.
        System.arraycopy(outputArray, 0, inputArray, 0, length);
    }

    /**
     * A non-comparative sorting algorithm that uses counting sort with Least Significant Digit (LSD) order.
     * Time Complexity Best: O(n + k), Average: O(nk), Worst: O(nk).
     * Space Complexity (Counting Sort): O(k + n).
     * @param array An unsorted array of integers.
     * @param length The length of the input array.
     */
    public void sort(int[] array, int length){

        int max = getMax(array, length);

        for (int place = 1; max / place > 0; place *= 10){
            countingSort(array, length, place);
        }
    }
}