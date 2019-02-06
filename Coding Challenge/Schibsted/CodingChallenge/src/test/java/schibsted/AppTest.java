package schibsted;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */

    @Test
    public void testGetFileName() {
        getFileName gfn = new getFileName("C://Users//risha//Desktop//Schibsted//CodingChallenge//src//TestFiles");
        ArrayList<String> outList = gfn.returnNames();
        ArrayList<String> correctList = new ArrayList<>();
        correctList.add("C:\\Users\\risha\\Desktop\\Schibsted\\CodingChallenge\\src\\TestFiles\\file1.txt");
        correctList.add("C:\\Users\\risha\\Desktop\\Schibsted\\CodingChallenge\\src\\TestFiles\\file2.txt");
        correctList.add("C:\\Users\\risha\\Desktop\\Schibsted\\CodingChallenge\\src\\TestFiles\\file3.txt");
        assertEquals(outList, correctList);
    }
}
