
import input.InputReaderFile;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void overallTest(){
       assertEquals("d, d", PathFinder.findPathFile("testFiles/maze2.txt"));
        assertEquals("no path found", PathFinder.findPathFile("testFiles/maze4.txt"));
    }

    @Test
    public void graphTest(){

    }

    @Test
    public void inputReaderFileTest(){
        InputReaderFile reader = new InputReaderFile("testFiles/smallMaze.txt");
        assertEquals("S.|.X", reader.readMaze());
    }}

