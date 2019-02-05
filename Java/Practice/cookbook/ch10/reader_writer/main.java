import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class main {
    public static String getSHA(String input) {

        try {

            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown" + " for incorrect algorithm: " + e);

            return null;
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        /*
         * String name = System.console().readLine("What is your name?");
         * System.out.println("Hello, " + name.toUpperCase());
         * System.out.println("Provide some input on terminal"); try { BufferedReader br
         * = new BufferedReader(new InputStreamReader(System.in)); String inputLine;
         * 
         * while ((inputLine = br.readLine()) != null) { System.out.println(inputLine);
         * } br.close(); } catch (IOException e) {
         * System.out.println("Caught I/O Exception"); }
         */

        // Password reading
        /*
         * char[] pwd = null; try { pwd = System.console().readPassword("Password: ");
         * System.out.println("Your Password is: " + new String(pwd));
         * System.out.println("SHA256 Encrypted Password: " + getSHA(pwd.toString()));
         * System.out.println(""); } catch (Exception e) { // TODO: handle exception }
         * finally { // Shred this in-memory copy for security reasons if (pwd != null)
         * { java.util.Arrays.fill(pwd, '0'); } }
         */

        


    }
}