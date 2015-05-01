/**
 * Created by Евгений on 01.04.2015.
 */
public class Edge {
    final int weight;
    final Vertex neighbor;
    Edge(Vertex neighbor, int weight){
        this.neighbor = neighbor;
        this.weight = weight;
    }
}
