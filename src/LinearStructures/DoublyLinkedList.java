package LinearStructures;

/**
 * DoublyLinkedList is a linear data structure of Nodes. Each node contains a value as well as a
 * reference to the next and previous nodes in the list. This allows for constant time insertion
 * and deletion of elements, at the cost of extra memory overhead compared to the singly linked list.
 */
public class DoublyLinkedList<T> implements LinearStructureInterface<T>, Pushable<T>, Poppable<T>{

    DoublyLinkedNode<T> head;
    DoublyLinkedNode<T> tail;

    int size;

    /**
     * Default constructor.
     */
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Check if the linked list is empty.
     * @return A boolean value for if the linked list contains elements.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Checks if the input element exists in the linked list.
     * @param element The element to be searched for in the linked list.
     * @return A boolean value for if the element is in the linked list.
     */
    @Override
    public boolean contains(T element) {
        if(isEmpty()){return false;}

        if(head.getValue() == element){return true;}

        DoublyLinkedNode<T> runner = head;
        while(runner.getNext() != null){
            if(runner.getNext().getValue() == element){
                return true;
            }
            runner = runner.getNext();
        }
        return false;
    }

    /**
     * @return An int value for the size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the last element (tail) of the list.
     * @return The value contained in the tail of the list.
     */
    @Override
    public T pop() {

        DoublyLinkedNode<T> temp = null;
        if(isEmpty()){return null;}
        if(head == tail){
            temp = head;
            head = tail = null;
            size--;
            return temp.getValue();
        }

        temp = tail;
        tail = null;
        size--;
        return temp.getValue();
    }

    /**
     * Add a new value to the beginning of the list.
     * @param value The value to be stored in the new head node.
     */
    @Override
    public void push(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(value);
        if(isEmpty()){
            head = tail = newNode;
        } else{
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }
}
