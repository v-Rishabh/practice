public class Main {
    public static void main(String[] args){
        char set[] = {'a', 'b', 'c', 'd'};
        printPowerSet(set);
    }

    public static void printPowerSet(char[] set){
        int len = set.length;
        for(int i=0; i<(1<<len); i++){
            for(int j=0; j<len; j++){
                if((i & (1<<j)) > 0)
                    System.out.print(set[j]);
            }
            System.out.println("");
        }
    }
}
