package Graphs;

import java.util.ArrayList;

/**
 * A graph of vertices connected by edges with no direction.
 */
public class UndirectedGraph<T> {

    private ArrayList<Vertex<T>> vertices;

    /**
     * Default constructor.
     */
    public UndirectedGraph(){
        this.vertices = new ArrayList<>();
    }

    /**
     * Add a new vertex to the graph with the input data.
     * @param data The data of type T to be added to the Graph.
     */
    public void addVertex(T data){
        Vertex<T> newVertex = new Vertex<>(data);
        vertices.add(newVertex);
    }

    /**
     * Deletes the input vertex from the graph/
     * @param vertex The vertex to be removed from the graph/
     */
    public void removeVertex(Vertex<T> vertex){
        vertices.remove(vertex);
    }

    /**
     * Adds and edge between two vertex.
     * @param source The starting vertex.
     * @param destination The destination vertex.
     */
    public void addEdge(Vertex<T> source, Vertex<T> destination){
        source.addEdge(destination);
    }

    /**
     * Removes the edge from between the two vertex.
     * @param source The starting vertex.
     * @param destination The end point vertex.
     */
    public void removeEdge(Vertex<T> source, Vertex<T> destination){
        source.removeEdge(destination);
    }
}
