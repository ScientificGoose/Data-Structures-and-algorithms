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
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(100);
        queue.enqueue(999);
    }

    @RepeatedTest(5)
    void push() {
        Random random = new Random();
        int testNum = random.nextInt();
        queue.enqueue(testNum);
        assertEquals(5, queue.peek());
    }

    @Test
    void pop() {
        Integer testOne = queue.dequeue();
        Integer testTwo = queue.dequeue();
        assertEquals(5, testOne);
        assertEquals(2, testTwo);
    }

    @Test
    void peek() {
        assertEquals(5, queue.peek());
        queue.dequeue();
        assertEquals(2, queue.peek());
        queue.dequeue();
        assertEquals(100, queue.peek());
    }

    @Test
    void size() {
        assertEquals(4, queue.size());
        queue.enqueue(11);
        assertEquals(5, queue.size());
        queue.dequeue();
        queue.dequeue();
        assertEquals(3, queue.size());
    }

    @Test
    void isEmpty() {
        assertFalse(queue.isEmpty());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}