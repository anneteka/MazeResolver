package processors;

import graph.Graph;

public class InputProcessor {
    //processes data from input readers and forms a graph
    public static Graph createGraph(String data) {
        return new Graph(process(data));
    }

    //returns string that contains all information about the graph
    //and has the structure as below
    //vertices_amount start_vertex finish_vertex vertex-vertex ... pairs of linked vertices
    public static String process(String data) {
        String[] maze=data.split("|");
        StringBuilder graph = new StringBuilder();
        graph.append(maze[0].length()*maze.length);

        return graph.toString();
    }
}
