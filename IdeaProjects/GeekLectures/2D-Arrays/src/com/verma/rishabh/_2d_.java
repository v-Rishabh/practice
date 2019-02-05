package com.verma.rishabh;

public class _2d_ {
    // Static Variables
    static int a = 10;
    static int b;

     /*
        If you need to do computation in order to initialize your static variables,
        you can declare a static block that gets executed exactly once, when the class is first loaded.
     */
    // Static Block
    static{
        System.out.println("Static Block Initialized");
        b = a * 5;
    }

    public static void StaticTest(){
        System.out.println("Static Method Called with class name reference");
    }

    public void _2dimensional_(){

        // Playing with Static keyword.
        System.out.println("Just Playing with static keyword, and value of b is :"+b);

        int[][] arr = {
                {1,2,3},
                {4,5,6,7},
                {8,9}};

        // Printing length of rows
        System.out.println("Length of row 1: "+arr[0].length);
        System.out.println("Length of row 2: "+arr[1].length);
        System.out.println("Length of row 3: "+arr[2].length);

        // Printing complete 2D-Array
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
