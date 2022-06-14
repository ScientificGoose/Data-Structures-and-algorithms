package LinearStructures;

public interface QueueableInterface<T> {

    void enqueue(T element);

    T dequeue();
}
