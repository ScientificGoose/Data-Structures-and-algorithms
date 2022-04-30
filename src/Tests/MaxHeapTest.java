package Tests;

import Trees.MaxHeap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {

    int[] testArray;
    MaxHeap testHeap;

    @BeforeEach
    void setUp() {
        //testArray = new int[] {55, 78, 99, 100, 62, 43, 60, 15, 1, -5, 12};
        //testArray = new int[] {100, 99, 78, 62, 60, 55, 43, 15, 12, 1, -5};
        testHeap = new MaxHeap(12);
        testHeap.insert(8);
        testHeap.insert(13);
        testHeap.insert(20);
        testHeap.insert(2);
        testHeap.insert(96);
        testHeap.insert(64);
        testHeap.insert(92);
        testHeap.insert(38);
        testHeap.insert(18);
        testHeap.insert(80);
        testHeap.insert(20);
        testHeap.insert(24);
    }

    @AfterEach
    void tearDown() {
        testArray = null;
        testHeap = null;
    }

    @Test
    void getSize() {
        assertEquals(12, testHeap.getSize());
    }

    @Test
    void insert() {
        assertEquals(12, testHeap.getSize());
    }

    @Test
    void getMax() {
    }

    @Test
    void extractMax() {
    }

    @Test
    void heapify() {
        testHeap.heapify(0);
        assertEquals("[96, 92, 80, 64, 38, 12, 8, 45, 18, 24, 20, 2]", Arrays.toString((testHeap.getHeapAsArray())));
    }
}