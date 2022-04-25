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
        stack.push(5);
        stack.push(2);
        stack.push(100);
        stack.push(999);
    }

    @RepeatedTest(5)
    void push() {
        Random random = new Random();
        int testNum = random.nextInt();
        stack.push(testNum);
        assertEquals(testNum, stack.peek());
    }

    @Test
    void pop() {
        Integer testOne = stack.pop();
        Integer testTwo = stack.pop();
        assertEquals(999, testOne);
        assertEquals(100, testTwo);
    }

    @Test
    void peek() {
        assertEquals(999, stack.peek());
        stack.pop();
        assertEquals(100, stack.peek());
        stack.push(22);
        stack.push(40);
        assertEquals(40, stack.peek());
    }

    @Test
    void size() {
        assertEquals(4, stack.size());
        stack.push(11);
        assertEquals(5, stack.size());
        stack.pop();
        stack.pop();
        assertEquals(3, stack.size());
    }

    @Test
    void isEmpty() {
        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}