package LinearStructures;

public class LinkedList<T> implements LinearStructInterface<T> {

    private Node<T> head;
    private int length;

    private class Node<T>{
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList(){
        this.head = null;
        this.length = -1;
    }

    @Override
    public void push(T data) {

        Node<T> newNode = new Node<>(data);

        if(isEmpty()){
            this.head = newNode;
        }
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

        Node<T> temp = head;
        Node<T> prev = new Node<>(null);
        while(position > -1){
            prev = temp;
            temp = temp.next;
            position--;
        }
        prev.next = new Node<>(data);
        prev.next.next = temp;
        length++;
        return true;
    }

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

    @Override
    public boolean isEmpty() {
        return head == null;
    }

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
