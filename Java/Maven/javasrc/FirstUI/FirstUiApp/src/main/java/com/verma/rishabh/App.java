package com.verma.rishabh;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // System.out.println( "Hello World!" );
		String OperatinSystemName = System.getProperty("os.name").toString();
		System.out.println("OS Name :" + OperatinSystemName);
        String javaVersion = System.getProperty("java.specification.version").toString();
        System.out.println("Currently Installed Java version in you system is :" + javaVersion);
        try {
            Class.forName("RISHABH");
        } catch (ClassNotFoundException e) {
            String faliureMessage = "Cannot found Class RISHABH! But this is ment to be like this. :p";
            JOptionPane.showMessageDialog(null, faliureMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
