package Graphs;

import java.util.ArrayList;

/**
 * Vertex represents a point in a Graph. It contains T type data and has n number of connected
 * edges.
 */
public class Vertex<T> {

    private T data;
    private ArrayList<Edge<T>> edges;

    /**
     * Default constructor.
     * @param data Data of type T to be stored in the vertex.
     */
    public Vertex(T data){
        this.data = data;
        this.edges = new ArrayList<Edge<T>>();
    }

    /**
     * Adds a connection to the input vertex.
     * @param vertex The Vertex to be connected to.
     */
    protected void addEdge(Vertex<T> vertex){
        this.edges.add(new Edge<>(this, vertex));
    }

    /**
     * Removes the connection to the input Vertex.
     * @param vertex The vertex to have the connection broken.
     */
    protected void removeEdge(Vertex<T> vertex){
        edges.removeIf(edge -> edge.getDestination().equals(vertex));
    }

    /**
     * @return the list of edges connected to the Vertex.
     *
     */
    protected ArrayList<Edge<T>> getEdges(){
        return this.edges;
    }
}
