import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] table = new int[][]{
                {0,0,1,1,3},
                {0,0,2,1,2},
                {1,2,0,3,1},
                {1,1,3,0,0},
                {3,3,1,0,0}
        };
        Graph myGraph = new Graph(table);
        System.out.println(myGraph.MinimumSpanningTree());
        /*int n = 6000;
        int[][] table2 = new int[n][n];
        for (int i = 0; i < table2.length; i++) {
            for (int j = 0; j < table2.length; j++) {
                if (i>j)
                    table2[j][i] = table2[i][j] = new Random().nextInt(n);
                //System.out.println("Generation " + i + " " + j);
            }
        }
        Graph myGraph = new Graph(table2);
        //  System.out.println(myGraph.toString());

        for (int i = 1; i < n; i++) {
            double t = myGraph.Dijkstra("5", "985");
                System.out.println(myGraph.getPathByDijkstra("5", Integer.toString(i)));

            }
        //new Graph(new int[][]{{1,1},{1,1}}).Dijkstra("1","1",1);
        long  start = System.currentTimeMillis();
        myGraph.Dijkstra("5", 5);
        System.out.println(myGraph.getPathByDijkstra("5", "2"));
        long stop = System.currentTimeMillis();
*/


       /* table2 = new int[n][n];
        for (int i = 0; i < table2.length; i++) {
            for (int j = 0; j < table2.length; j++) {
                if (i>j)
                    table2[j][i] = table2[i][j] = new Random().nextInt(n);
                //System.out.println("Generation " + i + " " + j);
            }
        }
        myGraph = new Graph(table2);
        long start2 = System.currentTimeMillis();
        myGraph.Dijkstra("5", 7);
        System.out.println(myGraph.getPathByDijkstra("5", "2"));
        long stop2 = System.currentTimeMillis();
        System.out.println(stop2 - start2);
        System.out.println("d = 5 : " + (stop - start));
        System.out.println("d = 7 : " + (stop2 - start2));*/

    }

}

