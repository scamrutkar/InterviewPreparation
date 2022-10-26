package org.javacase.sagar.ds.graph;

import java.util.LinkedList;

public class Graph {

    public int v;
    public LinkedList<Integer> adj[];

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int u){
        adj[v].add(u);
    }

    public void printGraph(){

    }
}
