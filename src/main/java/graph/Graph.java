package graph;

import java.util.ArrayList;

/**
 * {@code Graph} contains information about the maze as a graph
 */
public class Graph {

    /**
     * contains the index numbers of the start and end vertices
     */
    private int startVertex, finishVertex;

    /**
     * the width of the maze
     */
    private int width;

    /**
     * all adjacent vertices (edges)
     */
    private ArrayList<Integer>[] edges;

    /**
     * Constructs an object that contains information about the maze as a graph.
     * @param maze is an array of {@link String} where each string represents maze line
     */
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


    /**
     * @return vertices amount
     */
    public int getVerticesAmount() {
        return edges.length;
    }

    /**
     * @return start vertex
     */
    public int getStartVertex() {
        return startVertex;
    }

    /**
     * @return end vertex
     */
    public int getFinishVertex() {
        return finishVertex;
    }

    /**
     * @return all edges between vertices
     */
    public ArrayList<Integer>[] getAdj() {
        return edges;
    }

    /**
     * @return the width of th graph
     */
    public int getWidth() {
        return width;
    }

}
