package LinearStructures;

public interface LinearStructInterface<T> {

    void push(T data);

    T pop();

    boolean isEmpty();

    boolean contains(T data);
}
