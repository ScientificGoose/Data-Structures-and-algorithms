package LinearStructures;

/**
 * Having a private node class will eliminate the risk of the Nodes/data being changed
 * from outside the linked list.
 */
class Node<T>{
    T value;

    /**
     * This is the default constructor.
     * @param value The data to be stored in the Node.
     */
    Node(T value) {
        this.value = value;
    }
}
