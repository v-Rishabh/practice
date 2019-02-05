package com.verma.rishabh;

public class Main {
    public static void main(String[] args){
        System.out.println("Min Cost Path Problem:");
        System.out.println("Recursive Solution");
        minCost_path _minPath_ = new minCost_path();
        int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };

        System.out.println(_minPath_.minCost(cost,2,2));
        System.out.println("Solution using Tabulation. Complexity O(mn).");
        System.out.println(_minPath_.minCostTabulation(cost,2,2));
    }
}
