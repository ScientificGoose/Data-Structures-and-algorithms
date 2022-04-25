package LinearStructures;

/**
 * The LinkedList is a series of "Nodes" that are linked together in a single direction.
 * Big O:
 *  Best case O(1) <- element being inserted is at the head of the list.
 *  Worst case O(n) <- The time taken is proportional to the number of elements that need
 *  to be traversed for an insert. The element being added to the tail of the list is the worst case.
 */
public class LinkedList<T> implements LinearStructInterface<T> {

    private Node<T> head;
    private int length;

    /**
     * Having a private node class will eliminate the risk of the Nodes/data being changed
     * from outside the linked list.
     */
    private class Node<T>{
        T data;
        Node<T> next;

        /**
         * This is the default constructor.
         * @param data The data to be stored in the Node.
         */
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * This is the default constructor.
     */
    public LinkedList(){
        this.head = null;
        this.length = -1;
    }

    /**
     * This method will insert a new element at the end of the list.
     * @param data The data to be added to the list.
     */
    @Override
    public void push(T data) {

        Node<T> newNode = new Node<>(data);

        // If the list is empty, add the new node as the head of the list.
        if(isEmpty()){
            this.head = newNode;
        }

        // Otherwise add the new data to the end of the list.
        else{
            Node<T> runner = head;
            while(runner.next != null){
                runner = runner.next;
            }
            runner.next = newNode;
        }
        length++;
    }

    /**
     * Insert data at a specified position in linked list.
     * @param data Type T input data.
     * @param position Integer value for insertion index.
     * @return Returns if insertion was successful.
     */
    public boolean add(T data, int position){

        // The requested index is greater than stack length + 1.
        if(position > length + 1){
            System.out.print("Index out of bounds, cannot add data to list.");
            return false;
        }

        // If the position is at the first element in the list.
        if(position == 0){
            Node<T> temp = head;
            head = new Node<>(data);
            head.next = temp;
            length++;
            return true;
        }

        // Move to the requested position in the list.
        Node<T> temp = head;
        Node<T> prev = new Node<>(null);
        while(position > -1){
            prev = temp;
            temp = temp.next;
            position--;
        }

        // Insert the data into the list.
        prev.next = new Node<>(data);
        prev.next.next = temp;
        length++;
        return true;
    }

    /**
     * Remove the last element in the list.
     * @return A boolean value if the operation was successfull.
     */
    @Override
    public T pop() {
        if (isEmpty()) {return null;}
        Node<T> runner = head;
        Node<T> prev = new Node<>(null);
        while(runner.next != null){
            prev = runner;
            runner = runner.next;
        }
        Node<T> temp = runner;
        prev.next = null;
        return temp.data;
    }

    /**
     * Remove the requested data from the list.
     * @param data The data to be removed.
     * @return A boolean operation for if the operation was completed.
     */
    public T remove(T data) {
        if(isEmpty()){return null;}
        Node<T> runner = head;
        Node<T> prev = new Node<>(null);
        while(runner != null){
            if(runner.data == data){
                Node<T> temp = runner;
                prev.next = runner.next.next;
                runner = null;
                return temp.data;
            }
            prev = runner;
            runner = runner.next;
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
     * @param data The data to be searched for.
     * @return A boolean value for if the list contains the requested data.
     */
    @Override
    public boolean contains(T data) {
        // Check if the list is empty.
        if(isEmpty()){return false;}
        // Check if the head is the data being searched.
        if(head.data == data){
            return false;
        }
        Node<T> runner = head;
        while(runner.next != null){
            if(runner.data == data){
                return true;
            }
            runner = runner.next;
        }
        return false;
    }
}
