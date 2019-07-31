import graph.BreadthFirstSearch;
import graph.Graph;
import input.AbstractInputReader;
import input.InputReaderConsole;
import input.InputReaderFile;
import processors.InputProcessor;
import processors.PathToString;

public class PathFinder {
    public static String findPathConsole(){
        return findPath(new InputReaderConsole());
    }
    public static String findPathFile(String file){
        return findPath(new InputReaderFile(file));
    }

    private static String findPath(AbstractInputReader reader){
        String mazeData = reader.readMaze();
        String processedMazeData = InputProcessor.process(mazeData);
        Graph maze = new Graph(processedMazeData);
        BreadthFirstSearch bfs = new BreadthFirstSearch(maze);
        String path = PathToString.pathToString(maze, bfs.pathTo(maze.getFinishVertex()));
        return path;
    }
}
