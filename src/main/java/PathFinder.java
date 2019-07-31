import graph.BreadthFirstSearch;
import graph.Graph;
import input.AbstractInputReader;
import input.InputReaderConsole;
import input.InputReaderFile;
import processors.InputProcessor;
import processors.PathToString;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PathFinder {

    public String findPathConsole(){
        return findPath(new InputReaderConsole(), System.in);
    }
    public String findPathFile(String file) throws FileNotFoundException {
        return findPath(new InputReaderFile(), new FileInputStream(new File(file)));
    }

    private String findPath(AbstractInputReader reader, InputStream source){
        String[] mazeData = reader.readMaze(source);
        String processedMazeData = InputProcessor.process(mazeData);
        Graph maze = new Graph(processedMazeData);
        BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
        String path = PathToString.pathToString(maze, bfs.pathTo(maze.getFinishVertex()));
        return path;
    }
}
