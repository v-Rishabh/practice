import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("aaa");
        Matcher m = p.matcher("aaabsdfhgafaaaaaalkdflknaaamvviendsoooaa");

        while (m.find()) {
            System.out.println("Pattern found from " + m.start() + " to " + (m.end() - 1));
        }
    }
}