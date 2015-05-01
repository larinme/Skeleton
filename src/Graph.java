import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graph{

    Vertex[] vertex;
    private int[][] table;
    public Graph(int[][] table){
        vertex = new Vertex[table.length];
        for (int i = 0; i < table.length; i++) {
            vertex[i] = new Vertex(Integer.toString(i + 1));
        }
        for (int i = 0; i < table.length; i++) {
            vertex[i].adj = makeEdges(table[i]);
        }
        this.table = table;
    }
    public void Dijkstra(String a, int d) {
        Vertex start = vertex[findIndexOfVertexByName(a)];
        start.fromStartToThis = 0;
        PriorityQueue<Vertex> priorityQueue= new PriorityQueue<Vertex>();
        priorityQueue.add(start);
        while (!priorityQueue.isEmpty()) {
            //DHeap daryHeap = new DHeap(vertex.length, d);
            //for (int i = 0; i < vertex.length; i++) {
            //  daryHeap.insert(vertex[i]);
            //}
            while (priorityQueue.size() > 0) {//!daryHeap.isEmpty()){
                Vertex v = priorityQueue.poll();
                // Vertex v = daryHeap.delete(0);
                // System.out.println(daryHeap.getHeapSize());
                for (int i = 0; i < v.adj.length; i++) {
                    Vertex u = v.adj[i].neighbor;
                    double weight = v.adj[i].weight;
                    double distanceThroughThis = weight + v.fromStartToThis;
                    if (distanceThroughThis < u.fromStartToThis) {
                        priorityQueue.remove(v);
                        u.fromStartToThis = distanceThroughThis;
                        u.setPrevious(v);
                        //int indexInHeap = daryHeap.findIndex(u);
                        //if (indexInHeap != -1)
                        //daryHeap.heapifyUp(indexInHeap);
                        priorityQueue.add(u);
                    }
                }
            }
        }
    }
    public String getPathByDijkstra(String a, String b){
        //this.Dijkstra(a,b);
        List<Vertex> path = new ArrayList<Vertex>();
        Vertex start = vertex[findIndexOfVertexByName(a)];
        Vertex end = vertex[findIndexOfVertexByName(b)];
        try {
            for (; end != start; end = (end.getPrevious())) {
                path.add(end);
            }
        }catch (NullPointerException e){
            return "There's no path";
        }
        path.add(start);
        Collections.reverse(path);

        return path.toString();
    }

    public String MinimumSpanningTree(){
        int[] U = new int[table.length];
        Vertex start = vertex[0];
        U[0] = 1;
        PriorityQueue<Vertex> priorityQueue= new PriorityQueue<Vertex>();
        priorityQueue.add(start);
        while (!priorityQueue.isEmpty()){
            Vertex v = priorityQueue.poll();
            double minWeight = Double.MAX_VALUE;
            Vertex u = null;
            for (int i = 0; i < v.adj.length; i++) {
                Vertex tmp = v.adj[i].neighbor;
                if (minWeight > v.adj[i].weight )
                    if(U[findIndexOfVertexByName(tmp.getName())] == 0){
                    minWeight = v.adj[i].weight;
                    u = v.adj[i].neighbor;
                }
                if (U[findIndexOfVertexByName(tmp.getName())] == 0)
                priorityQueue.add(tmp);
            }

            v.setPreviousOstov(u);
            U[findIndexOfVertexByName(u.getName())] = 1;

        }


        List<Vertex> path = new ArrayList<Vertex>();
        Vertex s = vertex[0];
        Vertex end = vertex[vertex.length - 1];
        try {
            for (; end != start; end = (end.getPreviousOstov())) {
                path.add(end);
            }
        }catch (NullPointerException e){
            return "There's no path";
        }
        path.add(start);
        Collections.reverse(path);

        return path.toString();
    }

    private Edge[] makeEdges(int[] line){
        int count = 0;
        for (int i = 0; i < line.length; i++) {
            if (line[i] != 0) count++;
        }
        int k =0;

            Edge[] edges = new Edge[count];
            for (int i = 0; i < line.length; i++) {
                if (line[i] != 0) {
                    edges[k++] = new Edge(vertex[i], line[i]);
                }
            }

        return edges;
    }
    private int findIndexOfVertexByName(String name){
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getName().equals(name))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                stringBuilder.append(table[i][j] + " ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
