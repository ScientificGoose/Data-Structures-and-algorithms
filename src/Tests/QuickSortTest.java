package Tests;

import Sorts.QuickSort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;

class QuickSortTest {

    QuickSort test;
    int[] testArray;
    int[] sortedArray;
    Random rand;

    @BeforeEach
    void setUp() {

        test = new QuickSort();
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
    void sort() {

        System.out.printf("Unsorted: %s\n", Arrays.toString(testArray));
        test.sort(testArray, 0, testArray.length - 1);
        System.out.printf("Sorted:   %s\n", Arrays.toString(testArray));
        System.out.printf("Expected: %s\n", Arrays.toString(sortedArray));
        assertArrayEquals(sortedArray, testArray);
    }
}