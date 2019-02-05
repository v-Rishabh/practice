/******************************************************************************

 First repeating Character

 *******************************************************************************/
public class Main
{
    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    /* calculate count of characters
    in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length(); i++){
            //System.out.print(str.charAt(i)+" ");
            count[str.charAt(i)]++;
        }
        /*for(Character c : count){
            System.out.print((int)c+" ");
        }*/
    }

    // get First Non zero value.
    static int firstRepeating(String str)
    {
        getCharCountArray(str);
        int index = -1, i;

        for (i = 0; i < str.length(); i++)
        {
            if (count[str.charAt(i)] > 0)
            {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        int index = firstRepeating(str);

        System.out.println(index == -1 ? "Either none of the characters are repeating " : "\nFirst repeating character is " + str.charAt(index));

    }
}

