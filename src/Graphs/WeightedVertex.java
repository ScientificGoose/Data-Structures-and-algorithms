package Graphs;

public class WeightedVertex<T> extends Vertex<T>{


    public WeightedVertex(T data){
        super(data);
    }
    /**
     * Adds a connection to the input vertex.
     * @param vertex The Vertex to be connected to.
     */
    protected void addEdge(Vertex<T> vertex, Double weight){
        super.getEdges().add(new WeightedEdge<>(this, vertex, weight));
    }
}
