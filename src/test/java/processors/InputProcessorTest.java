package processors;

import graph.Graph;
import input.InputReaderFile;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputProcessorTest {

    @Test
    public void graphGenerationTest() {
        InputReaderFile reader = new InputReaderFile("/testFiles/maze1.txt");
        Graph graph = new Graph(reader.readMaze());

    }
}