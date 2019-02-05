/* Dynamic Programming Longest Common Subsequence Problem */

public class LongestCommonSubsequence {

    int lcs(char[] X, char[] Y, int m, int n){
        int L[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if(X[i-1] == Y[j-1])
                    //If value of I and J matches Eg: A and A, then We will take element Diagonally up on left side and increment it by 1.
                    //This Character is a match in Subsequence.
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    //We will take maximum value out of 2 values. First Value on left and second value is value above it.
                    L[i][j] = max(L[i-1][j],L[i][j-1]);
            }
        }
        return L[m][n];
    }

    int max(int a, int b){
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "abppplee";
        String[] D = {"able", "ale", "apple", "bale", "kangaroo"};

        int __maxValue__ = 0;
        int __resultElement__ = -1;
        int __Element__ = -1;
        for(String str: D){
            __Element__ += 1;
            String s2 = str;
            char[] X = s1.toCharArray();
            char[] Y = s2.toCharArray();
            int m = X.length;
            int n = Y.length;

            int tempLCS = lcs.lcs( X, Y, m, n );
            if (tempLCS > __maxValue__){
                __maxValue__ = tempLCS;
                __resultElement__ = __Element__;
            }
            else
                continue;
        }
        System.out.println("Length of LCS is" + " " +__maxValue__+" "+"and Element Position is : "+__resultElement__);
        System.out.println(D[__resultElement__]+" is LCS of "+s1);
    }
}
