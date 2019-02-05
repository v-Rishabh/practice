package com.rishabh.verma;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
 /*       int v,e,count=1,to=0,from=0;
        Scanner sc = new Scanner(System.in);

        AdjacencyMatrix graphMatrix;

        try {
            System.out.println("Enter the Number of vertices");
            v = sc.nextInt();
            System.out.println("Enter the number of edges");
            e = sc.nextInt();

            graphMatrix = new AdjacencyMatrix(v);

            System.out.println("Enter the edges <to> <from>");
            while(count <= e){
                to = sc.nextInt();
                from = sc.nextInt();

                graphMatrix.makeEdge(to, from, 1);
                count++;
            }

            System.out.println("The adjacency matrix for the given graphMatrix is: ");
            System.out.print("  ");
            for (int i = 1; i <= v; i++)
                System.out.print(i + " ");
            System.out.println();

            for (int i = 1; i <= v; i++)
            {
                System.out.print(i + " ");
                for (int j = 1; j <= v; j++)
                    System.out.print(graphMatrix.getEdge(i, j) + " ");
                System.out.println();
            }
        }
        catch (Exception E)
        {
            System.out.println("Something went wrong");
        }

        sc.close();

        /*
            Sample Input for Adjacency Matrix
            Enter the number of vertices:
            5
            Enter the number of edges:
            7
            Enter the edges: <to> <from>
            1 1
            2 3
            3 4
            4 5
            3 5
            1 4
            2 4

         */


        // Adjacency List
        AdjacencyList _AL_ = new AdjacencyList(4);
        _AL_.addEdge(0, 1);
        _AL_.addEdge(0, 2);
        _AL_.addEdge(0, 3);
        _AL_.addEdge(1, 3);


        System.out.println("==============Adjacency List=============");
        _AL_.printGraph(_AL_);
        System.out.println("Following is Breadth First Traversal ");
        _AL_.BFS(2);

        // Cycle Check in Undirected Graph.
        if(_AL_.isCyclicUndirected()){
            System.out.println("\nCycle Found");
        }
        else{
            System.out.println("\nCycle not Found");
        }


        //System.out.println("\nFollowing is Depth First Traversal "+"(starting from vertex 2)");
        //_AL_.DFS(2);
    }
}
