package com.verma.rishabh;
import java.awt.Dimension;

public class Main {
    //static final int primitive = 10;
    public static void main(String[] args){
        // ========== Passing reference variable to method as reference ==================== //
        ReferenceTest rt = new ReferenceTest();
        Dimension d1 = new Dimension(5,10);
        // Test
        System.out.println("Before modify : "+d1.height);
        rt.modify(d1);
        System.out.println("After Modify : "+d1.height);

        // ========== Now Passing primitive variable to method as reference ==================== //
        int primitive = 10;
        // Tests
        System.out.println("Before modify : "+primitive);
        rt.modifyPrimitive(primitive);
        System.out.println("After Modify : "+primitive);
    }
}
