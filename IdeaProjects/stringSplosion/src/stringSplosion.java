/*
    stringSplosion
    stringSplosion("Code") → "CCoCodCode"
    stringSplosion("abc") → "aababc"
    stringSplosion("ab") → "aab"

 */


public class stringSplosion {

    public static String Splosion(String str) {
        String result = "";
        int iterator = -1;
        char[] s = str.toCharArray();
        for(int i=0; i< s.length; i++){
            iterator++;
            for(int j=0; j<=iterator; j++){
                //System.out.print(s[j]);
                String temp = Character.toString(s[j]);
                result = result.concat(temp);
            }
        }
        return result;
    }

    public static void main(String args[]){
        String r1 = Splosion("Code");
        System.out.println("Splosion for [Code] is "+r1);
        String r2 = Splosion("abc");
        System.out.println("Splosion for [abc] is "+r2);
        String r3 = Splosion("ab");
        System.out.println("Splosion for [ab] is "+r3);
    }
}
