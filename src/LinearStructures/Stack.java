package LinearStructures;

import java.util.EmptyStackException;

public class Stack<T> implements LinearStructInterface<T> {

    Node<T> top;
    int size;

    private class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public Stack(){
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    @Override
    public void push(T data) {

        Node<T> temp = new Node<>(data);
        temp.next = top;
        top = temp;
        size++;
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            size--;
            return item;
    }

    public T peek(){
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

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
