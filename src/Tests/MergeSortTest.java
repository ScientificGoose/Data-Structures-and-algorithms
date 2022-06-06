package Tests;

import Sorts.MergeSort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    int[] testArray;
    int[] sortedArray;
    Random rand;
    MergeSort mergeSort;

    @BeforeEach
    void setup(){
        mergeSort = new MergeSort();
        testArray = new int[200];
        rand = new Random();

        for (int i = 0; i < testArray.length - 1; i++) {
            testArray[i] = rand.nextInt();
        }

        sortedArray = Arrays.stream(testArray).sorted().toArray();
    }

    @Test
    void sort() {

        System.out.printf("Unsorted: %s\n", Arrays.toString(testArray));
        mergeSort.sort(testArray, 0, testArray.length - 1);
        System.out.printf("Sorted:   %s\n", Arrays.toString(testArray));
        System.out.printf("Expected: %s\n", Arrays.toString(sortedArray));
        assertArrayEquals(sortedArray, testArray);
    }
}