
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void overallTest(){
       assertEquals("d, d", PathFinder.findPathFile("testFiles/maze2.txt"));
    }

}
