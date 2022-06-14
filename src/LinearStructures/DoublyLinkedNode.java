package LinearStructures;

/**
 * This Node contains Data of type T, a pointer to a previous Node and a pointer to the next Node.
 */
public class DoublyLinkedNode<T> extends Node<T> {

    private DoublyLinkedNode<T> prev;
    private DoublyLinkedNode<T> next;

    /**
     * default constructor.
     * @param value an object of type T.
     */
    public DoublyLinkedNode(T value){
        super(value);
        this.prev = null;
        this.next = null;
    }

    /**
     * Retrieve the value from the Node.
     * @return The value of data type T stored in the node.
     */
    protected T getValue(){
        return super.value;
    }

    /**
     * Update the value stored in the node.
     * @param value object of type T to be stored in the Node.
     */
    protected void setValue(T value){
        super.value = value;
    }

    /**
     * Get the previous Node in the chain.
     * @return The pointer to the previous node in the chain.
     */
    protected DoublyLinkedNode<T> getPrev(){
        return this.prev;
    }

    /**
     * Update the previous node in the chain.
     * @param prev A Node to be added as the previous node.
     */
    protected void setPrev(DoublyLinkedNode<T> prev){
        this.prev = prev;
    }

    /**
     * Get the next Node in the chain.
     * @return The pointer to the next node in the chain.
     */
    protected DoublyLinkedNode<T> getNext(){
        return next;
    }

    /**
     * Update the next node in the chain.
     * @param next A Node to be added as the next node.
     */
    protected void setNext(DoublyLinkedNode<T> next){
        this.next = next;
    }
}
