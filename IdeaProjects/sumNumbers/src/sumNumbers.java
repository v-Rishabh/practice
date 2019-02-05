/*
    Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
    A number is a series of 1 or more digit chars in a row. (Note: Character.isDigit(char) tests if a
    char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an int.)

    Numbers("abc123xyz") → 123
    Numbers("aa11b33") → 44
    Numbers("7 11") → 18
 */

public class sumNumbers {

    public static int Numbers(String str) {
        int len = str.length();
        int sum = 0;
        String tmp = "";

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(str.charAt(i))) {
                if (i < len-1 && Character.isDigit(str.charAt(i+1))) {
                    tmp += str.charAt(i);
                }
                else {
                    tmp += str.charAt(i);
                    sum += Integer.parseInt(tmp);
                    tmp = "";
                }

            }
        }

        return sum;
    }

    public static void main(String args[]){
        int r1 = Numbers("abc123xyz");
        System.out.println(r1);

        int r2 = Numbers("aa11b33");
        System.out.println(r2);

        int r3 = Numbers("7 11");
        System.out.println(r3);

    }
}
