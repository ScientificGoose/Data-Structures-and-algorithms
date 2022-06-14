package LinearStructures;

import java.util.NoSuchElementException;

/**
 * The Queue uses a First in First Out (FIFO) order of operations. The elements being processed
 * will be removed from the queue in the order that they entered.
 * Big O:
 *  Best case O(1) <- The element entered into the queue is the only element to be processed.
 *  Worst case O(n) <- The time taken is proportional to the number of elements that need
 *      to be processed.
 */
public class Queue<T> implements LinearStructureInterface<T>, QueueableInterface<T> {

    SinglyLinkedNode<T> head;
    SinglyLinkedNode<T> tail;
    int size;

    /**
     * This is the default constructor.
     */
    public Queue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Get the current size of the Queue.
     * @return The number of elements in the Queue.
     */
    public int size(){
        return size;
    }

    /**
     * This method will add a new Node to the end of the Queue.
     * @param data The data to be pushed to the queue
     */
    @Override
    public void enqueue(T data) {
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<>(data);
        if(tail != null){
            tail.setNext(temp);
        }
        tail = temp;
        if(head == null){
            head = tail;
        }
        size++;
    }

    /**
     * This method will remove the element at the head of the Queue.
     * @return The data contained in the head Node.
     */
    @Override
    public T dequeue() {
        if(head == null) throw new NoSuchElementException();
        T data = head.getData();
        head = head.getNext();
        if(head == null){
            tail = null;
        }
        size--;
        return data;
    }

    /**
     * This method will return the data in the head Node, but not remove it from the queue.
     * @return The data from the head node.
     */
    public T peek() {
        if(head == null) throw new NoSuchElementException();
        return head.getData();
    }

    /**
     * Checks if the Queue is empty.
     * @return A boolean value if the Queue is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Checks to see if the input data is in the Queue.
     * @param data The data to be searched for.
     * @return A boolean value for if the data is in the queue.
     */
    @Override
    public boolean contains(T data) {
        if(isEmpty()){return false;}
        if(head.getData() == data){return true;}
        SinglyLinkedNode<T> runner = head;
        while(runner.getNext() != null){
            if(runner.getData() == data){
                return true;
            }
            runner.setNext(runner.getNext());
        }
        return false;
    }
}
