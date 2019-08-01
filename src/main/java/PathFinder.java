import graph.BreadthFirstSearch;
import graph.Graph;
import input.InputReader;
import input.InputReaderConsole;
import input.InputReaderFile;
import processors.PathDescriptor;

import java.io.*;

/**
 * {@code PathFinder} solves the problem of finding path in the maze.
 */
public class PathFinder {

    /**
     * finds the final path needed with the data collected from the user input
     * @return the final path
     * @throws IOException
     */
    public String findPathConsole() throws IOException {
        return findPath(new InputReaderConsole(), System.in);
    }

    /**
     * finds the final path needed with the data collected from the file
     * @param file name of the file that contains the maze
     * @return the final path
     * @throws IOException
     */
    public String findPathFile(String file) throws IOException {
        return findPath(new InputReaderFile(), new FileInputStream(new File(file)));
    }

    /**
     * solves the problem of finding path in the maze
     * @param reader {@link InputReaderConsole} or {@link InputReaderFile}
     * @param source input stream that contains the maze
     * @return the final path
     * @throws IOException
     */
    private String findPath(InputReader reader, InputStream source) throws IOException {
        String[] mazeData = reader.readMaze(source);
        var maze = new Graph(mazeData);
        var bfs = new BreadthFirstSearch(maze);
        var pathDescriptor = new PathDescriptor();
        return pathDescriptor.describe(maze.getWidth(), bfs.pathTo(maze.getFinishVertex()));
    }
}
