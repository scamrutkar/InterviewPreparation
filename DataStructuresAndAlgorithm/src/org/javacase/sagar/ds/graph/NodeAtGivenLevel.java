package org.javacase.sagar.ds.graph;

import java.util.LinkedList;
import java.util.List;

public class NodeAtGivenLevel {

    Graph graph;

    public NodeAtGivenLevel(Graph graph){
        this.graph = graph;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        int level = 2;

        NodeAtGivenLevel nodeAtGivenLevel = new NodeAtGivenLevel(graph);
        System.out.println("Total Node at "+level+" Level - "+nodeAtGivenLevel.countNodes(2));


    }

    private int countNodes(int l) {

        int[] level = new int[graph.v];
        boolean[] visited = new boolean[graph.v];
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        visited[0] = true;

        while(!list.isEmpty()){
            int vertex = list.poll();
            List<Integer> adjList = graph.adj[vertex];
            for (Integer adjVertex : adjList) {
                if(!visited[adjVertex]){
                    visited[adjVertex] = true;
                    list.add(adjVertex);
                    level[adjVertex] = level[vertex] + 1;
                }
            }
        }
        for (int i : level) {
            if(i == l)
                count++;
        }
        return count;
    }

}


