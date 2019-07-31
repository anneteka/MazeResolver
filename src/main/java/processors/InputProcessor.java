package processors;

import graph.Graph;

import java.util.ArrayList;

public class InputProcessor {

    //returns string that contains all information about the graph
    //and has the structure as below
    //vertices_amount start_vertex finish_vertex vertex-vertex ... pairs of linked vertices
    public Graph process(String[] maze) {
        int height = maze.length;
        int width = maze[0].length();
        int verticesAmount = height * width;
        int edgesAmount = 0;
        int startVertex = 0, finishVertex = 0;
        ArrayList<Integer>[] edges = new ArrayList[verticesAmount];
        int current;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                current = i * maze[i].length() + j;
                if (maze[i].charAt(j) != '#') {
                    if (maze[i].charAt(j) == 'S') {
                        startVertex = current;
                    }
                    if (maze[i].charAt(j) == 'X') {
                        finishVertex = current;
                    }

                    if (i > 0 && maze[i - 1].charAt(j) != '#') {
                        edges[current].add(current - maze[i].length());
                        edgesAmount++;
                    }
                    if (i < maze.length - 1 && maze[i + 1].charAt(j) != '#') {
                        edges[current].add(current + maze[i].length());
                        edgesAmount++;
                    }
                    if (j > 0 && maze[i].charAt(j - 1) != '#') {
                        edges[current].add(current - 1);
                        edgesAmount++;
                    }
                    if (j < maze[i].length() - 1 && maze[i].charAt(j + 1) != '#') {
                        edges[current].add(current + 1);
                        edgesAmount++;
                    }
                }
            }
        }

        return new Graph(verticesAmount, height, width, edgesAmount, startVertex, finishVertex, edges);
    }
}
