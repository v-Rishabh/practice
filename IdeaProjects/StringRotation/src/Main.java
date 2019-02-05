/******************************************************************************

Find if one string is rotation of other string.
// Logic : Concatinate String 1 with itself and search the string 2 in string 1.
 *******************************************************************************/

public class Main {

    public static void isRotated(String str1, String  str2){
        // Concatinate String 1 with itself;
        String toCheck = str1+str1;
        int len = str2.length();
        boolean isRotated = false;
        //System.out.println(len);
        for(int i=0; i<toCheck.length()-4; i++){
            String sub = toCheck.substring(i,i+4);
            //System.out.println(sub +" "+str2);
            if(sub.equals(str2)){
                isRotated = true;
            }
            else{
                // keep it false
                continue;
            }
        }
        if(isRotated){
            System.out.println("String 2 is rotation of String 1");
        }
        else{
            System.out.println("String 2 is not a rotation of String 1");
        }
    }
    public static void main(String args[]){

        String str1 = "ABCD";
        String str2 = "CDAB";
        isRotated(str1,str2);
    }
}
