package org.javacase.sagar.ds.graph;

/*
* Strongly Connected Component: A directed graph is strongly connected if there is a path between all pairs of vertices.
* A strongly connected component (SCC) of a directed graph is a maximal strongly connected subgraph. For example, there are 3 SCCs in the following graph.
* */

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajusAlogorithm {

    private Graph graph;

    private Stack<Integer> stack;

    public KosarajusAlogorithm(Graph graph){
        this.graph = graph;
        this.stack = new Stack<>();
    }

   public void DFSTraversal(boolean[] visited){
        for(int i=0;i<graph.v;i++){
            if(!visited[i]){
                DFSUtil(i,visited);
            }
        }
    }

    private void DFSUtil(int v, boolean[] visited) {

        System.out.print(v+" ");
        stack.push(v);
        visited[v] = true;

        List<Integer> adjList = graph.adj[v];
        for (Integer adjV : adjList) {
            if(!visited[adjV])
                DFSUtil(adjV, visited);
        }

    }

    private void DFSUtil1(int v, boolean[] visited) {

        System.out.print(v+" ");
        visited[v] = true;

        List<Integer> adjList = graph.adj[v];
        for (Integer adjV : adjList) {
            if(!visited[adjV])
                DFSUtil1(adjV, visited);
        }

    }

    private Graph getTranspose() {

        Graph gr = new Graph(graph.v);
        for(int v=0;v<graph.v;v++){
            List<Integer> adjList = graph.adj[v];
            for(Integer u : adjList){
                gr.addEdge(u,v);
            }
        }

        return gr;
    }

    private void kosarajuAlgo() {

        boolean[] visited = new boolean[graph.v];
        DFSTraversal(visited);

        Arrays.fill(visited, false);
        System.out.println();

        Graph gr = getTranspose();

        while(!stack.isEmpty()){

            int v = stack.pop();

            if(!visited[v]){
                DFSUtil1(v,visited);
                System.out.println();
            }

        }


    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0,1);

        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,1);

        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(6,7);
        g.addEdge(7,5);

        KosarajusAlogorithm ka = new KosarajusAlogorithm(g);
        ka.kosarajuAlgo();
    }

}
