package org.javacase.sagar.ds.graph;

import java.util.LinkedList;

public class BFSTraversal {

    public void BFSTraversal(Graph graph, int vertex){

        boolean[] visited = new boolean[graph.v];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while(!queue.isEmpty()){

            vertex = queue.poll();
            System.out.println(vertex+" ");

            LinkedList<Integer> list = graph.adj[vertex];

            for (Integer i : list) {
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }

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

        BFSTraversal bfs = new BFSTraversal();
        bfs.BFSTraversal(graph,2);


    }

}
