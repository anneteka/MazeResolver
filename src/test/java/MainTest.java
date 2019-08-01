
import graph.BreadthFirstSearch;
import graph.Graph;
import input.InputReaderFile;
import org.junit.Test;
import processors.PathDescriptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void overallTest() throws IOException {
        PathFinder pathFinder = new PathFinder();
        assertEquals("d, d", pathFinder.findPathFile("testFiles/maze2.txt"));
        assertEquals("no path found", pathFinder.findPathFile("testFiles/maze4.txt"));
    }

    @Test
    public void pathDescriptorTest() {
        //012
        //345
        //678
        var path = new ArrayList<Integer>();
        path.add(1);
        path.add(2);
        path.add(5);
        path.add(8);
        path.add(7);
        int width = 3;
        PathDescriptor descriptor = new PathDescriptor();

        assertEquals("r, d, d, l", descriptor.describe(width, Optional.of(path)));
    }

    @Test
    public void inputReaderFileTest() throws IOException {
        InputReaderFile reader = new InputReaderFile();
        String[] maze = {"S.",".X"};
        assertArrayEquals(maze, reader.readMaze(new FileInputStream(new File("testFiles/smallMaze.txt"))));
    }

    @Test
    public void bsfTest() throws IOException {
        var reader = new InputReaderFile();
        var graph = new Graph(reader.readMaze(new FileInputStream(new File("testFiles/maze2.txt"))));
        var bfs = new BreadthFirstSearch(graph);
        var path = new ArrayList<Integer>();
        path.add(6);
        path.add(11);
        path.add(16);
        assertTrue(bfs.pathTo(graph.getFinishVertex()).isPresent());
        assertEquals(path, bfs.pathTo(graph.getFinishVertex()).get());
    }
    @Test
    public void bsfTestBigMaze() throws IOException {
        var reader = new InputReaderFile();
        var graph = new Graph(reader.readMaze(new FileInputStream(new File("testFiles/maze1.txt"))));
        var bfs = new BreadthFirstSearch(graph);

        assertTrue(bfs.pathTo(graph.getFinishVertex()).isPresent());
        assertEquals(35, bfs.pathTo(graph.getFinishVertex()).get().size());
    }

    @Test
    public void graphTest() throws IOException{
        var reader = new InputReaderFile();
        var graph = new Graph(reader.readMaze(new FileInputStream(new File("testFiles/smallMaze.txt"))));
        assertEquals(4, graph.getVerticesAmount());
        assertEquals(0, graph.getStartVertex());
        assertEquals(3, graph.getFinishVertex());
        assertEquals(2, graph.getWidth());

        ArrayList<Integer>[] edges = graph.getAdj();
        assertTrue(edges[0].contains(1));
        assertTrue(edges[0].contains(2));
        assertTrue(edges[1].contains(0));
        assertTrue(edges[1].contains(3));
        assertTrue(edges[2].contains(0));
        assertTrue(edges[2].contains(3));
        assertTrue(edges[3].contains(1));
        assertTrue(edges[3].contains(2));
    }

}

