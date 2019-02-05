import java.io.*;
import java.util.*;

public class hangman_one {
    public static void main(String args[]){

        //Instructions:
        System.out.println("Welcome to Hangman, You hve to Guess the digit in 8 tries to save the man from Hanging.");

        //Variable Initialization
        ArrayList<String> arr1 = new ArrayList<>(5); //Hold the Values which are selected randomly.
        String printDash = "";

        arr1.add("one");
        arr1.add("two");
        arr1.add("three");
        arr1.add("four");
        arr1.add("five");

        System.out.println("Test Start");
        int random = new Random().nextInt(5);
        String __RandomValueSelectedToGuess__ = arr1.get(random);
        int elementLength = __RandomValueSelectedToGuess__.length();

        for(int i=0; i<elementLength; i++){
            printDash += "_";
        }
        for(char c: printDash.toCharArray()) {
            System.out.print(c);
            System.out.print(',');
        }
        System.out.println();

        //This ArrayList holds the randomly selected value to check if it contains the character entered by user or not.
        ArrayList<Character> __ToGuessAsList__ = new ArrayList<>();
        for(char items: __RandomValueSelectedToGuess__.toCharArray()){
            __ToGuessAsList__.add(items);
        }

        // ------------ Till Selected Word and Print Dashes ------------------

        char[] res = __RandomValueSelectedToGuess__.toCharArray();
        int j = 0;
        char[] __ResultArray__ = printDash.toCharArray();
        char __UserGuess__ = Character.MIN_VALUE;
        int __Try_Count__ = 0;
        while(__Try_Count__<8){
            if(Arrays.equals(__ResultArray__, __RandomValueSelectedToGuess__.toCharArray())){
                //If resulting array is equal to randomValueSelectedToGuess then Exit.[Found the word correctly.]
                break;
            }
            else{
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                System.out.println("\nEnter a guess: Try no "+__Try_Count__);
                __UserGuess__ = reader.next().charAt(0); // Scans the next token of the input as an int.
                //reader.close();
                if(__ToGuessAsList__.contains(__UserGuess__)){
                    for(char ch: __RandomValueSelectedToGuess__.toCharArray()){

                        if(__UserGuess__ == ch){
                            __ResultArray__[j] = __UserGuess__;
                        }
                        else{
                            //Do Nothing, As [ch] already matched with 1 or more elements. NO PENALTY.
                        }
                        j++;
                    }
                    j=0;
                    __Try_Count__++; //Increment the Count of tries.

                }
                else{
                    //Increment Tries count on wrong answer.
                    __Try_Count__++;
                }

                for(char _Item_: __ResultArray__){
                    System.out.print(_Item_);
                    System.out.print(',');
                }
            }

        }
        if(Arrays.equals(__ResultArray__, __RandomValueSelectedToGuess__.toCharArray()) && __Try_Count__ < 8){
            System.out.println("\n SAVIOUR..You Guessed it right");
        }
        else{
            System.out.println("\n Man Hanged");
        }
    }
}
