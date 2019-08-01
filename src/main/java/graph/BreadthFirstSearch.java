package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

/**
 * {@code BreadthFirstSearch} is an implementation of BFS algorithm.
 * It calculates the shortest possible path from the start vertex to
 * the given by the {@link #pathTo(int)} method.
 */
public class BreadthFirstSearch {

    /**
     * The maze in wich the shortest path is searched.
     */
    private Graph graph;

    /**
     * contains information about the starting point in the maze.
     */
    private int startVertex;

    /**
     * final that represents an infinite value.
     */
    private static final int INFINITY = -1;

    /**
     * marked[v] = is there an s-v path.
     */
    private boolean[] marked;

    /**
     * edgeTo[v] = previous edge on shortest s-v path.
     */
    private int[] edgeTo;

    /**
     * distTo[v] = number of edges shortest s-v path
     */
    private int[] distTo;

    /**
     * Constructs an object that holds information about the shortest path from the
     * {@link Graph#startVertex} in the given {@link Graph} to any of the other vertices
     * @param g graph, in which the shortest paths between the vertices should be calculated
     */
    public BreadthFirstSearch(Graph g) {
        marked = new boolean[g.getVerticesAmount()];
        distTo = new int[g.getVerticesAmount()];
        edgeTo = new int[g.getVerticesAmount()];
        graph = g;
        startVertex = g.getStartVertex();
        bfs();
    }

    /**
     * Calculates the paths between the vertices in the {@link #graph}
     * and saves them in the {@link #edgeTo} as well as the length of the
     * given paths in the {@link #distTo}
     */
    private void bfs() {
        LinkedList<Integer> q = new LinkedList<>();
        for (int v = 0; v < graph.getVerticesAmount(); v++)
            distTo[v] = INFINITY;
        distTo[startVertex] = 0;
        marked[startVertex] = true;
        q.addLast(startVertex);

        while (!q.isEmpty()) {
            int v = q.removeFirst();
            for (int w : graph.getAdj()[v]) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.addLast(w);
                }
            }
        }
    }

    /**
     * Returns the path from the start vertex to the given vertex.
     * Returns empty {@link Optional} if there is no path.
     *
     * @param v the index number of the vertex to which the path is searched
     * @return the path from the start vertex to the given vertex as {@link Optional} of the {@link ArrayList}
     */
    public Optional<ArrayList<Integer>> pathTo(int v) {
        if (!hasPathTo(v)) return Optional.empty();
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; distTo[x] != 0; x = edgeTo[x])
            path.addFirst(x);
        path.addFirst(startVertex);
        return Optional.of(new ArrayList<>(path));
    }

    /**
     *
     * @param v the index number of the vertex to which the path is searched
     * @return {@code true}, if there is a path and {@code false} if there is no
     */
    private boolean hasPathTo(int v) {
        return marked[v];
    }
}
