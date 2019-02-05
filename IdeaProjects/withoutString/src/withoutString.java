/*
    Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed
    (not case sensitive).
    You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
       ---------------------------------------------
    withoutString("Hello there", "llo") → "He there"
    withoutString("Hello there", "e") → "Hllo thr"
    withoutString("Hello there", "x") → "Hello there"
 */

public class withoutString {

    public static String wString(String base, String remove) {
        String _base_ = base;
        String _remove_ = remove;
        String _result_Part1_ = _base_.replace(_remove_,"");

        String _remove_U = remove.toUpperCase();
        String _result_Part2_ =_result_Part1_.replace(_remove_U,"");

        String _remove_L_ = remove.toLowerCase();
        String _result_ =_result_Part2_.replace(_remove_L_,"");
        //System.out.println(_result_);
        return _result_;
    }

    public static void main(String args[]){
        String r1 = wString("Hello there", "llo");
        System.out.println(r1);
        String r2 = wString("Hello there", "e");
        System.out.println(r2);
        String r3 = wString("Hi HoHo", "Ho");
        System.out.println(r3);
    }
}
