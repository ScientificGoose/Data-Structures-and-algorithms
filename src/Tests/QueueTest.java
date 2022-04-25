package Tests;

import LinearStructures.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest<T> {

    Queue<Integer> queue;

    @BeforeEach
    void setUp(){
        queue = new Queue<>();
        queue.push(5);
        queue.push(2);
        queue.push(100);
        queue.push(999);
    }

    @RepeatedTest(5)
    void push() {
        Random random = new Random();
        int testNum = random.nextInt();
        queue.push(testNum);
        assertEquals(5, queue.peek());
    }

    @Test
    void pop() {
        Integer testOne = queue.pop();
        Integer testTwo = queue.pop();
        assertEquals(5, testOne);
        assertEquals(2, testTwo);
    }

    @Test
    void peek() {
        assertEquals(5, queue.peek());
        queue.pop();
        assertEquals(2, queue.peek());
        queue.pop();
        assertEquals(100, queue.peek());
    }

    @Test
    void size() {
        assertEquals(4, queue.size());
        queue.push(11);
        assertEquals(5, queue.size());
        queue.pop();
        queue.pop();
        assertEquals(3, queue.size());
    }

    @Test
    void isEmpty() {
        assertFalse(queue.isEmpty());
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        assertTrue(queue.isEmpty());
    }
}