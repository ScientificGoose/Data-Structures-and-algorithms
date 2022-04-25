package LinearStructures;

import java.util.EmptyStackException;

/**
 * The Stack uses a Last in First Out (LIFO) order of operations. The elements being processed
 * will be removed from the top of the Stack.
 * Big O:
 *  Best case O(1) <- The element entered into the stack is on the top of the stack.
 *  Worst case O(n) <- The time taken is proportional to the number of elements that need
 *      to be processed.
 */
public class Stack<T> implements LinearStructInterface<T> {

    Node<T> top;
    int size;

    /**
     * Having a private node class will eliminate the risk of the Nodes/data being changed
     * from outside the Stack.
     */
    private class Node<T>{
        T data;
        Node<T> next;

        /**
         * This is the default constructor.
         * @param data The data to be stored in the Node.
         */
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * This is the default constructor.
     */
    public Stack(){
        top = null;
        size = 0;
    }

    /**
     * This method returns the size of the Stack.
     * @return The number of elements in the stack.
     */
    public int size(){
        return size;
    }

    /**
     * This method will add a new element to the top of the stack.
     * @param data The data to be added to the top of the stack.
     */
    @Override
    public void push(T data) {

        Node<T> temp = new Node<>(data);
        temp.next = top;
        top = temp;
        size++;
    }

    /**
     * This method will remove the top element in the stack.
     * @return The data contained in the top element of the stack.
     */
    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    /**
     * This will return the data from the top of the stack without removing the element from the stack.
     * @return The data contained in the top node of the stack.
     */
    public T peek(){
        return top.data;
    }

    /**
     * This method will check if the stack is empty.
     * @return A boolean value for if the stack contains any elements.
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * This method will check if the input data already exists in the Stack.
     * @param data The data to be searched for.
     * @return A boolean value for if the data is in the Stack.
     */
    @Override
    public boolean contains(T data) {
        if(isEmpty()) {return false;}
        if(top.data == data){return true;}
        Node<T> runner = top;
        while(runner.next != null){
            if(runner.next.data == data){
                return true;
            }
            runner = runner.next;
        }
        return false;
    }
}
