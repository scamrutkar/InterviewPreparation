package org.javacase.sagar.ds.graph;

import java.util.Arrays;

/*The Floyd Warshall Algorithm is for solving all pairs shortest path problems.
The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed Graph.*/

public class FlyodWarshallAlgorithm {

    final static int INF = 99999, V = 4;

    public static void main(String[] args) {

        int graph[][] = { { 0, 5, INF, 10 },
                { INF, 0, 3, INF },
                { INF, INF, 0, 1 },
                { INF, INF, INF, 0 } };

        FlyodWarshallAlgorithm algo = new FlyodWarshallAlgorithm();
        algo.allPairsShortestPath(graph);

    }

    private int[][] allPairsShortestPath(int[][] graph) {

        int[][] dist = graph;

        for(int k = 0; k < V; k++){
            for (int i = 0; i < V; i++){
                for (int j = 0; j < V; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                System.out.print(dist[i][j]+" ");
            }
            System.out.println("");
        }

        return dist;
    }

}
