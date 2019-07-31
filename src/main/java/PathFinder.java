import graph.BreadthFirstSearch;
import graph.Graph;
import input.AbstractInputReader;
import input.InputReaderConsole;
import input.InputReaderFile;
import processors.InputProcessor;
import processors.PathDescriptor;

import java.io.*;

public class PathFinder {

    public String findPathConsole() throws IOException {
        return findPath(new InputReaderConsole(), System.in);
    }
    public String findPathFile(String file) throws IOException {
        return findPath(new InputReaderFile(), new FileInputStream(new File(file)));
    }

    private String findPath(AbstractInputReader reader, InputStream source) throws IOException {
        String[] mazeData = reader.readMaze(source);
        InputProcessor processor = new InputProcessor();
        String processedMazeData = processor.process(mazeData);
        Graph maze = new Graph(processedMazeData);
        BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
        PathDescriptor pathDescriptor = new PathDescriptor();
        return pathDescriptor.describe(maze, bfs.pathTo(maze.getFinishVertex()));
    }
}
