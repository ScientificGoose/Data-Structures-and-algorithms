package LinearStructures;

/**
 * The LinkedList is a series of "Nodes" that are linked together in a single direction.
 * Big O:
 *  Best case O(1) <- element being inserted is at the head of the list.
 *  Worst case O(n) <- The time taken is proportional to the number of elements that need
 *  to be traversed for an insert. The element being added to the tail of the list is the worst case.
 */
public class SinglyLinkedList<T> implements LinearStructureInterface<T>, Pushable<T>, Poppable<T> {

    private SinglyLinkedNode<T> head;
    private int size;

    /**
     * This is the default constructor.
     */
    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns the current size of the linked list.
     * @return an int value of the size of the linked list.
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * This method will insert a new element at the end of the list.
     * @param value The data to be added to the list.
     */
    @Override
    public void push(T value) {

        SinglyLinkedNode<T> newNode = new SinglyLinkedNode<>(value);

        // If the list is empty, add the new node as the head of the list.
        if(isEmpty()){
            this.head = newNode;
        }

        // Otherwise, add the new data to the end of the list.
        else{
            SinglyLinkedNode<T> runner = head;
            while(runner.getNext() != null){
                runner = runner.getNext();
            }
            runner.setNext(newNode);
        }
        size++;
    }

    /**
     * Insert data at a specified position in linked list.
     * @param data Type T input data.
     * @param position Integer value for insertion index.
     */
    public void add(T data, int position){

        // The requested index is greater than array size.
        if(position > size){
            throw new IndexOutOfBoundsException("Index " + position + " is out of bounds!");
        }

        // If the position is at the first element in the list.
        if(position == 0){
            SinglyLinkedNode<T> temp = head;
            head = new SinglyLinkedNode<>(data);
            head.setNext(temp);
            size++;
        }

        // Move to the requested position in the list.
        SinglyLinkedNode<T> temp = head;
        SinglyLinkedNode<T> prev = new SinglyLinkedNode<>(null);
        while(position > -1){
            prev = temp;
            temp = temp.getNext();
            position--;
        }

        // Insert the data into the list.
        prev.setNext(new SinglyLinkedNode<>(data));
        prev.getNext().setNext(temp);
        size++;
    }

    /**
     * Remove the last element in the list.
     * @return A boolean value if the operation was successful.
     */
    @Override
    public T pop() {
        if (isEmpty()) {return null;}
        SinglyLinkedNode<T> runner = head;
        SinglyLinkedNode<T> prev = new SinglyLinkedNode<>(null);
        while(runner.getNext() != null){
            prev = runner;
            runner = runner.getNext();
        }
        Node<T> temp = runner;
        prev.setNext(null);
        return temp.value;
    }

    /**
     * Remove the requested data from the list.
     * @param element The data to be removed.
     * @return A boolean operation for if the operation was completed.
     */
    public T remove(T element) {
        if(isEmpty()){return null;}
        SinglyLinkedNode<T> runner = head;
        SinglyLinkedNode<T> prev = new SinglyLinkedNode<>(null);
        while(runner != null){
            if(runner.value == element){
                prev.setNext(runner.getNext().getNext());
                return runner.value;
            }
            prev = runner;
            runner = runner.getNext();
        }
        return null;
    }

    /**
     * Check if the list has elements.
     * @return A boolean value for if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Check to see if a value is in the list.
     * @param element The data to be searched for.
     * @return A boolean value for if the list contains the requested data.
     */
    @Override
    public boolean contains(T element) {
        // Check if the list is empty.
        if(isEmpty()){return false;}
        // Check if the head is the data being searched.
        if(head.value == element){
            return false;
        }
        SinglyLinkedNode<T> runner = head;
        while(runner.getNext() != null){
            if(runner.value == element){
                return true;
            }
            runner = runner.getNext();
        }
        return false;
    }
}
