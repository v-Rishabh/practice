import static org.junit.Assert;

public class unitTest {
    public void squareTest(int a) {
        ToTest tt = new ToTest();
        int output = tt.getSqaure(5);
        assertEquals(25, output);

    }

    public static void main(String[] args) {
        unitTest ut = new unitTest();
        ut.squareTest(5);
    }
}