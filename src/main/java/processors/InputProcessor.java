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
        String[] maze = data.split("\\|");
        StringBuilder graph = new StringBuilder();
        graph.append(maze[0].length() * maze.length);
        graph.append(' ');
        int startVertex = 0, finishVertex = 0;
        int current;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                current = i * maze[i].length() + j;
                if (maze[i].charAt(j) != '#') {
                    if (maze[i].charAt(j) == 'S') {
                        startVertex = current;
                    }
                    if (maze[i].charAt(j) == 'X') {
                        finishVertex = current;
                    }

                    if (i > 0 && maze[i - 1].charAt(j) != '#') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current - maze[i].length());
                        graph.append(' ');
                    }
                    if (i < maze.length - 1 && maze[i + 1].charAt(j) != '#') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current + maze[i].length());
                        graph.append(' ');
                    }
                    if (j > 0 && maze[i].charAt(j - 1) != '#') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current - 1);
                        graph.append(' ');
                    }
                    if (j < maze[i].length() - 1 && maze[i].charAt(j + 1) != '#') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current + 1);
                        graph.append(' ');
                    }
                }
            }
        }
        graph.append(maze.length);//height of the maze
        graph.append(' ');
        graph.append(maze[0].length());//width of the maze
        graph.append(' ');
        graph.append(startVertex);
        graph.append(' ');
        graph.append(finishVertex);
        return graph.toString();
    }
}
