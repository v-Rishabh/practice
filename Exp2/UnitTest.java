import static org.junit.Assert.*;
import org.junit.Test;

class UnitTest{
	@Test
    public void testAdd()
    {
        Main mainClass = new Main(); //Setup object to Test
        int result = mainClass.add(2,8); //Call the method to Test
        assertEquals(10, result, 0); //Verify        
    }

}