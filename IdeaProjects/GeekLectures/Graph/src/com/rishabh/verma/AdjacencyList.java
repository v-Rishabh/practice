package com.rishabh.verma;

import java.util.*;

public class AdjacencyList {
    int v;
    // Array of linked lists
    LinkedList<Integer> AdjListArray[];

    public AdjacencyList(int V){
        this.v = V;
        AdjListArray = new LinkedList[V];

        for(int i=0; i < V; i++){
            AdjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        // Undirected Graph
        AdjListArray[src].addLast(dest);

        AdjListArray[dest].addLast(src);
    }

    public void printGraph(AdjacencyList graph){
        for(int v =0; v<graph.v; v++){
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer val: graph.AdjListArray[v]){
                System.out.print(" -> "+val);
            }
            System.out.println("\n");
        }
    }

    public void BFS(int root){
        // v => Vertices
        boolean visited[] = new boolean[v];
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(root);
        visited[root] = true;

        while(!Q.isEmpty()){
            root = Q.poll();
            System.out.print(root+ " ");

            Iterator<Integer> i = AdjListArray[root].listIterator();

            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    Q.offer(n);
                }
            }
        }
    }

    public void DFS(int V){
        boolean visited[] = new boolean[v];
        DFS_UTIL(V,visited);
    }
    public void DFS_UTIL(int V, boolean visited[]){
        visited[V] = true;
        System.out.print(V+" ");

        Iterator<Integer> i = AdjListArray[V].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFS_UTIL(n,visited);
            }
        }
    }


    // Checking Cycle in UnDirected Graph
    public boolean checkCycleUndirected(int V, boolean visited[], int parent){
        // Mark current vertex as visited
        visited[V] = true;

        Iterator<Integer> it = AdjListArray[V].listIterator();
        while (it.hasNext()){
            int n = it.next();

            if(!visited[n]){
                if (checkCycleUndirected(n,visited,v)){
                    return true;
                }
            }
            else if(n != parent){
                return true;
            }
        }
        return false;
    }

    public boolean isCyclicUndirected(){
        boolean visited[] = new boolean[v];

        Arrays.fill(visited,false);

        for(int u=0; u<v; u++){
            if(!visited[u]){
                if(checkCycleUndirected(u,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }
}
