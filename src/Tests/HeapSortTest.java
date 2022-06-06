package Tests;

import Sorts.HeapSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    HeapSort test;
    int[] testArray;
    int[] sortedArray;
    Random rand;

    @BeforeEach
    void setUp() {

        test = new HeapSort();
        testArray = new int[10];
        rand = new Random();

        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = rand.nextInt(-100, 100);
        }

        sortedArray = Arrays.stream(testArray).sorted().toArray();
    }

    @AfterEach
    void tearDown() {
        testArray = null;
        sortedArray = null;
        test = null;
    }

    @Test
    void sortAscending() {

        System.out.printf("Unsorted: %s\n", Arrays.toString(testArray));
        test.sortAscending(testArray);
        System.out.printf("Sorted:   %s\n", Arrays.toString(testArray));
        System.out.printf("Expected: %s\n", Arrays.toString(sortedArray));
        assertArrayEquals(sortedArray, testArray);
    }

    @Test
    void sortDescending() {

        for(int i = 0; i < sortedArray.length / 2; i++){
            int temp = sortedArray[i];
            sortedArray[i] = sortedArray[sortedArray.length - 1 - i];
            sortedArray[sortedArray.length - 1 - i] = temp;
        }

        System.out.printf("Unsorted: %s\n", Arrays.toString(testArray));
        test.sortDescending(testArray);
        System.out.printf("Sorted:   %s\n", Arrays.toString(testArray));
        System.out.printf("Expected: %s\n", Arrays.toString(sortedArray));
        assertArrayEquals(sortedArray, testArray);
    }
}