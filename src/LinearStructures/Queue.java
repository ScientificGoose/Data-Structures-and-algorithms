package LinearStructures;

import java.util.NoSuchElementException;

public class Queue<T> implements LinearStructInterface<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    private class Node<T>{

        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public Queue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    @Override
    public void push(T data) {
        Node<T> temp = new Node<>(data);
        if(tail != null){
            tail.next = temp;
        }
        tail = temp;
        if(head == null){
            head = tail;
        }
        size++;
    }

    @Override
    public T pop() {
        if(head == null) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if(head == null) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T data) {
        if(isEmpty()){return false;}
        if(head.data == data){return true;}
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
