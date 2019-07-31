
import input.InputReaderFile;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void overallTest() throws FileNotFoundException {
        PathFinder pathFinder = new PathFinder();
        assertEquals("d, d", pathFinder.findPathFile("testFiles/maze2.txt"));
        assertEquals("no path found", pathFinder.findPathFile("testFiles/maze4.txt"));
    }

    @Test
    public void graphTest() {

    }

    @Test
    public void inputReaderFileTest() throws FileNotFoundException {
        InputReaderFile reader = new InputReaderFile();
        String[] maze = {};
        assertEquals(maze, reader.readMaze(new FileInputStream(new File("testFiles/smallMaze.txt"))));
    }
}

