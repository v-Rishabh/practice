public class Main {

        static final int NO_OF_CHARS = 256;
        static char count[] = new char[NO_OF_CHARS];

        /* calculate count of characters in the passed string */
        static void getCharCountArray(String str)
        {
            for (int i = 0; i < str.length(); i++){
                //System.out.print(str.charAt(i)+" ");
                count[str.charAt(i)]++;
            }
        }

        static int match(String str){
            int result = 1;

            for(int i=0; i<str.length(); i++){
                count[str.charAt(i)]--;
            }

            // Check for index value other than 1.
            for(int i=0; i<count.length; i++){
                if(count[i] == 0){
                    continue;
                }
                else{
                    result = -1;
                    break;
                }
            }

            return result;
        }

        public static void main(String[] args) {
            getCharCountArray("gfg");
            int res = match("ggf");
            System.out.println(res == -1 ? "Not Anagram" : "Anagram");

            getCharCountArray("abcd");
            int res2 = match("aabbcg");
            System.out.println(res2 == -1 ? "Not Anagram" : "Anagram");
        }
}
