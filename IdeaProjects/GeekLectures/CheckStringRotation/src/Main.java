public class Main {
    public static void main(String[] args){
        String s1 = "ABCDE";
        String s2 = "EABCD";
        boolean res = isRotation(s1,s2);
        System.out.println("is S1 rotation of S2 : "+res);
    }

    public static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        String s3 = s1 + s1;
        int matchLen = s2.length();
        int i =0;
        while(i < s3.length()/2){
            String toMatch = s3.substring(i,i+matchLen);
            System.out.println(toMatch);
            if(toMatch.equals(s2))
                return true;
            i++;
        }
        return false;
    }
}
