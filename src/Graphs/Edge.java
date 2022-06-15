package Graphs;

/**
 * Edge represents a connection between two vertices on in a Graph.
 */
public class Edge<T> {

    private Vertex<T> source;
    private Vertex<T> destination;

    /**
     * Default constructor.
     * @param source The starting Vertex.
     * @param destination The endpoint Vertex.
     */
    public Edge(Vertex<T> source, Vertex<T> destination){
        this.source = source;
        this.destination = destination;
    }

    /**
     * @return The source Vertex of the edge, containing type T data.
     */
    protected Vertex<T> getSource(){
        return this.source;
    }

    /**
     * @return The destination Vertex of the edge, containing type T data.
     */
    protected Vertex<T> getDestination(){
        return this.destination;
    }
}
