package graph;

import java.util.ArrayList;

public class Graph {
    //contains information about the maze as graph

    private int startVertex, finishVertex;
    private int width;
    private ArrayList<Integer>[] edges; //list of all adjacent vertices

    //data string contains all information about the graph
    //and has the structure as below
    //vertices_amount vertex-vertex ... pairs of linked verticesAmount height width start_vertex finish_vertex
    public Graph(String[] maze) {
        width = maze[0].length();

        startVertex = 0;
        finishVertex = 0;
        edges = new ArrayList[maze.length * width];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
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
                    }
                    if (i < maze.length - 1 && maze[i + 1].charAt(j) != '#') {
                        edges[current].add(current + maze[i].length());
                    }
                    if (j > 0 && maze[i].charAt(j - 1) != '#') {
                        edges[current].add(current - 1);
                    }
                    if (j < maze[i].length() - 1 && maze[i].charAt(j + 1) != '#') {
                        edges[current].add(current + 1);
                    }
                }
            }
        }
    }


    public int getVerticesAmount() {
        return edges.length;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getFinishVertex() {
        return finishVertex;
    }

    public ArrayList<Integer>[] getAdj() {
        return edges;
    }

    public int getWidth() {
        return width;
    }

//    @Override
//    public String toString() {
//        //todo
//        return null;
//    }

}
