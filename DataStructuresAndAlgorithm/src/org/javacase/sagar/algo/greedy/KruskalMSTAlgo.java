package org.javacase.sagar.algo.greedy;

import java.util.*;

public class KruskalMSTAlgo {

    static class Edge{
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph{
        int vertex;
        List<Edge> allEdges = new ArrayList<>();

        public Graph(int vertex){
            this.vertex = vertex;
        }

        public void addEdge(int source, int destination , int weight){
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge);
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph(4);

        graph.addEdge(0,1,2);
        graph.addEdge(0,2,3);
        graph.addEdge(0,3,4);

        graph.addEdge(1,3,5);

        graph.addEdge(2,3,6);

        KruskalMSTAlgo kruskalAlgo = new KruskalMSTAlgo();
        kruskalAlgo.kruskalMST(graph);

    }

    public void kruskalMST(Graph graph){

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(new EdgeComparator());

        for(Edge edge : graph.allEdges)
            minHeap.add(edge);

        int[] parent = new int[graph.vertex];
        makeSet(parent);

        List<Edge> result = new LinkedList<>();

        while(!minHeap.isEmpty()){

            Edge edge = minHeap.poll();

            int xSet = find(parent, edge.source);
            int ySet = find(parent, edge.destination);

            if(xSet != ySet){
                result.add(edge);
                union(parent, xSet, ySet);
            }
        }

        for (Edge edge : result) {
            System.out.println("Source : " +edge.source+", Destination: "+edge.destination+" :: Weight : "+edge.weight);
        }

    }

    private void union(int[] parent, int xSet, int ySet) {
        int xSetParent = find(parent, xSet);
        int ySetParent = find(parent, ySet);
        parent[ySetParent] = xSetParent;
    }

    private int find(int[] parent, int vertex) {
        if(parent[vertex] == vertex)
            return vertex;
        return find(parent, parent[vertex]);
    }

    public void makeSet(int[] parent){
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
    }

    public class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}
