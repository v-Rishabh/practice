package com.verma.rishabh;
import java.awt.Dimension;

public class ReferenceTest {
    void modify(Dimension d){
        d.height = d.height+1;
        System.out.println("[From Modify Method] Dimension Height = "+d.height);
    }

    void modifyPrimitive(int input){
        input++;
        System.out.println("Primitive Variable from modify method : "+input);
    }
}
