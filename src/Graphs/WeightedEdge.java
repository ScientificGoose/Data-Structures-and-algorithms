package Graphs;

public class WeightedEdge<T> extends Edge<T> {
    private Vertex<T> source;
    private Vertex<T> destination;
    private Double weight;

    /**
     * Default constructor.
     * @param source The starting Vertex.
     * @param destination The endpoint Vertex.
     */
    public WeightedEdge(Vertex<T> source, Vertex<T> destination, Double weight){
        super(source, destination);
        this.weight = weight;
    }

    /**
     * @return The weighted value of the edge.
     */
    public double getWeight(){
        return weight;
    }

    /**
     * Updates the weighted value of the Edge.
     * @param weight The weight of the edge.
     */
    public void setWeight(Double weight){
        this.weight = weight;
    }
}
