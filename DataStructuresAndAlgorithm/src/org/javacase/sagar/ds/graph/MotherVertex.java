package org.javacase.sagar.ds.graph;

import java.util.Arrays;

public class MotherVertex {

    private Graph graph;

    public MotherVertex(Graph graph){
        this.graph = graph;
    }

    public int motherVertex(){

        boolean[] visited = new boolean[graph.v];
        int lastVertex = -1;
        for(int v=0;v<graph.v;v++){
            if(!visited[v]){
                DFSUtil(v,visited);
                lastVertex = v;
            }
        }

        Arrays.fill(visited,false);
        DFSUtil(lastVertex,visited);

        for (boolean visit : visited) {
            if(!visit) return -1;
        }

        return lastVertex;
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        for(Integer u : graph.adj[v]){
            if(!visited[u]){
                DFSUtil(u,visited);
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

        MotherVertex mv = new MotherVertex(g);
        System.out.println("Mother Vertex : "+mv.motherVertex());
    }

}
