package org.javacase.sagar.ds.graph;

public class TransitiveClosureGraph {

    final static int INF = 99999, V = 4;

    private Graph graph;

    public TransitiveClosureGraph(Graph graph){
        this.graph = graph;
    }

    int[][] tc = new int[V][V];

    public static void main(String[] args) {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        TransitiveClosureGraph algo = new TransitiveClosureGraph(g);
        algo.transitiveClosureGraph();

    }

    private void transitiveClosureGraph() {
        for(int i = 0; i < V; i++){
            DFSUtil(i,i);
        }
        for (int i = 0; i < V; i++){
            for (int j = 0;  j < V; j++){
                System.out.print(tc[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private void DFSUtil(int s, int v) {
        if(s == v)
            tc[s][v] = 1;
        else tc[s][v] = 1;

        for(int u : graph.adj[v]){
            if(tc[s][u] == 0){
                DFSUtil(s,u);
            }
        }
    }
}
