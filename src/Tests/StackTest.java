package Tests;

import LinearStructures.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StackTest<T> {

    Stack<Integer> stack;

    @BeforeEach
    void setUp(){
        stack = new Stack<>();
        stack.enqueue(5);
        stack.enqueue(2);
        stack.enqueue(100);
        stack.enqueue(999);
    }

    @RepeatedTest(5)
    void push() {
        Random random = new Random();
        int testNum = random.nextInt();
        stack.enqueue(testNum);
        assertEquals(testNum, stack.peek());
    }

    @Test
    void pop() {
        Integer testOne = stack.dequeue();
        Integer testTwo = stack.dequeue();
        assertEquals(999, testOne);
        assertEquals(100, testTwo);
    }

    @Test
    void peek() {
        assertEquals(999, stack.peek());
        stack.dequeue();
        assertEquals(100, stack.peek());
        stack.enqueue(22);
        stack.enqueue(40);
        assertEquals(40, stack.peek());
    }

    @Test
    void size() {
        assertEquals(4, stack.size());
        stack.enqueue(11);
        assertEquals(5, stack.size());
        stack.dequeue();
        stack.dequeue();
        assertEquals(3, stack.size());
    }

    @Test
    void isEmpty() {
        assertFalse(stack.isEmpty());
        stack.dequeue();
        stack.dequeue();
        stack.dequeue();
        stack.dequeue();
        assertTrue(stack.isEmpty());
    }
}