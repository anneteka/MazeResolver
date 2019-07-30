package input;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputReaderFileTest {

    @Test
    public void readMazeTest() {
        InputReaderFile reader = new InputReaderFile("testFiles/maze1.txt");
        System.out.println(reader.readMaze());
    }
}