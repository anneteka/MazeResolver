package graph;

import input.InputReaderFile;
import org.junit.Test;
import processors.InputProcessor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {

    @Test
    public void pathTo() {
    }

    @Test
    public void hasPathTo() {
        InputReaderFile reader = new InputReaderFile("testFiles/maze2.txt");
        Graph graph = new Graph(InputProcessor.process(reader.readMaze()));
        BreadthFirstSearch search = new BreadthFirstSearch(graph, graph.getStartVertex());
        ArrayList<Integer> list = search.pathTo(graph.getFinishVertex());
        System.out.println(list==null?"null":list.toString());
        System.out.println("done");
    }
}