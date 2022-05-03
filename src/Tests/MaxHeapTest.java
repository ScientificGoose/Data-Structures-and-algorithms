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
        testHeap = new MaxHeap();
        testHeap.insert(17);
        testHeap.insert(25);
        testHeap.insert(10);
        testHeap.insert(20);
        testHeap.insert(15);
    }

    @AfterEach
    void tearDown() {
        testArray = null;
        testHeap = null;
    }

    @Test
    void getSize() {
        assertEquals(5, testHeap.getSize());
    }

    @Test
    void insert() {
        testHeap.insert(99);
        assertEquals(6, testHeap.getSize());
    }

    @Test
    void poll() {
        assertEquals("[25, 20, 10, 17, 15]", Arrays.toString(testHeap.getArray()));
        testHeap.poll();
        assertEquals("[20, 17, 10, 15]", Arrays.toString(testHeap.getArray()));
        testHeap.insert(30);
        assertEquals("[30, 20, 10, 15, 17]", Arrays.toString(testHeap.getArray()));
    }
}