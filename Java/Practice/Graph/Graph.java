import java.io.*;
import java.util.*;

class Graph {
    private int v; // No of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int v) {
        boolean[] visited = new boolean[v];
        dfsUtil(v, visited);
    }

    void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> itr = adj[v].listIterator();
        while (itr.hasNext()) {
            int n = itr.next();
            if (!visited[n]) {
                dfsUtil(n, visited);
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

        g.DFS(2);
    }
}