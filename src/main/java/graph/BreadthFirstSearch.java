package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BreadthFirstSearch {
    //calculates the shortest possible path
    private Graph graph;
    private int startVertex;

    private static final int INFINITY = -1;
    private boolean[] marked;  //is there an s-v path
    private int[] edgeTo;   //previous edge on shortest s-v path
    private int[] distTo;   //number of edges shortest s-v path

    //int source - start vertex in the maze
    public BreadthFirstSearch(Graph g, int source) {
        marked = new boolean[g.getVertices()];
        distTo = new int[g.getVertices()];
        edgeTo = new int[g.getVertices()];
        graph = g;
        startVertex = source;
        bfs();
    }

    private void bfs() {
        LinkedList<Integer> q = new LinkedList<Integer>();
        for (int v = 0; v < graph.getVertices(); v++)
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

    public ArrayList<Integer> pathTo(int v) {

        if (!hasPathTo(v)) return null;
        LinkedList<Integer> path = new LinkedList<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.addFirst(x);
        path.addFirst(x);
        return new ArrayList<Integer>(path);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
