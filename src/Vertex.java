/**
 * Created by Евгений on 01.04.2015.
 */
public class Vertex implements Comparable<Vertex>{
   public Edge[] adj;
   public  String name;
    private Vertex previous;
    private Vertex previousOstov;
    double fromStartToThis = Double.POSITIVE_INFINITY;
    Vertex(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Vertex getPrevious() {
        return previous;
    }
    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.fromStartToThis, o.fromStartToThis);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Vertex getPreviousOstov() {
        return previousOstov;
    }

    public void setPreviousOstov(Vertex previousOstov) {
        this.previousOstov = previousOstov;
    }
}
