package com.verma.rishabh;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String javaVersion = System.getProperty("java.specification.version").toString();
        assertTrue(javaVersion.equals("1.8"));
    }
}
