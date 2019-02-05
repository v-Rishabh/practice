package com.verma.rishabh;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Person p = new Person("Rishabh","Verma");
        String fullName = p.getFullName();
        System.out.println("Full Name is : "+fullName);
    }
}
