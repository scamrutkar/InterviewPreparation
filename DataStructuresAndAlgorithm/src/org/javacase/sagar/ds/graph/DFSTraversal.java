package org.javacase.sagar.ds.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFSTraversal {

    Graph graph;

    public DFSTraversal(Graph graph){
        this.graph = graph;
    }

    public void DFSTraversal(){

        boolean[] visited = new boolean[graph.v];

        for(int i=0;i<graph.v;i++){
            if(!visited[i]){
                DFSUtil(visited,i);
            }
        }

    }

    private void DFSUtil(boolean[] visited, int vertex){

        System.out.println(vertex);
        visited[vertex] = true;

        LinkedList<Integer> list = graph.adj[vertex];
        for (Integer element : list) {
            if(!visited[element])
                DFSUtil(visited, element);
        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        DFSTraversal dfs = new DFSTraversal(graph);
        dfs.DFSTraversal();
    }
}
