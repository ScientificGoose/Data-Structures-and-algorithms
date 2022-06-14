package LinearStructures;


/**
 * The singly linked node contains the Node data (super class) and a pointer to the next node.
 */
class SinglyLinkedNode<T> extends Node<T>{

    private SinglyLinkedNode<T> next;

    /**
     * Default constructor for SinglyLinkedNode
     * @param data The data of type T to be stored in the Node.
     */
    SinglyLinkedNode(T data){
        super(data);
        next = null;
    }

    /**
     * Get the data stored in the node.
     * @return Data of type T that is stored in the Node.
     */
    T getData(){
        return super.data;
    }

    /**
     * Update the data stored in the Node.
     * @param data Data of type T to be stored in the Node.
     */
    void setData(T data){
        super.data = data;
    }

    /**
     * Returns the Next Node in the linked list.
     * @return The pointer to the next node.
     */
    SinglyLinkedNode<T> getNext(){
        return next;
    }

    /**
     * Change the next Node.
     * @param next A singlyLinkedNode.
     */
    void setNext(SinglyLinkedNode<T> next){
        this.next = next;
    }
}
