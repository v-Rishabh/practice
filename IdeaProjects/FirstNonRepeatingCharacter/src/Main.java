/******************************************************************************

First non Repeating Character

 *******************************************************************************/
public class Main
{
    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];
    int result = -1;
    /* calculate count of characters
    in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length(); i++){
            count[str.charAt(i)]++;
        }
    }

    static int firstNonRepeating(String str)
    {
        getCharCountArray(str);
        int index = -1, i;

        for (i = 0; i < str.length(); i++)
        {
            if (count[str.charAt(i)] == 1)
            {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = firstNonRepeating(str);

        System.out.println(index == -1 ? "Either all characters are repeating or string " +
                "is empty" : "\nFirst non-repeating character is " + str.charAt(index));

    }
}
/*
            OPTIMAL Solution
   // get An answer on GeeksForGeeks
   int NonRepeatingCharacter(String str){
    pair<int,int>, count[256];
    for(int =0; i<str.length(); i++){
        if(count[str.charAt(i)]
    }

   }


 */
