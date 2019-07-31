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
        InputProcessor processor = new InputProcessor();
        String processedMazeData = processor.process(mazeData);
        Graph maze = new Graph(processedMazeData);
        BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
        PathToString pathToString = new PathToString();
        String path = pathToString.pathToString(maze, bfs.pathTo(maze.getFinishVertex()));
        return path;
    }
}
