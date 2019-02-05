package com.verma.rishabh;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PersonTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testFullName()
    {
        Person p = new Person("Rishabh","Verma");
        String expectedAnswer = "Rishabh Verma";
        String returnedName = p.getFullName();
        //assertEquals("Full Name Test","Rishabh Verma",returnedName);
        assertTrue(returnedName.equals(expectedAnswer));
    }
}
