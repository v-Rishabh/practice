package com.rishabh.verma;

public class AdjacencyMatrix {
    int vertices;
    int[][] adjacency_matrix;

    public AdjacencyMatrix(int v){
        this.vertices = v;
        adjacency_matrix = new int[vertices+1][vertices+1];
    }

    public void makeEdge(int to, int from, int edge){
        try {
            adjacency_matrix[to][from] = edge;
        }
        catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("The vertices does not exists");
        }
    }

    public int getEdge(int to, int from){
        try {
            return adjacency_matrix[to][from];
        }
        catch (ArrayIndexOutOfBoundsException index)
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

}
