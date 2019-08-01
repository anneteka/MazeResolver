package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {
    //calculates the shortest possible path
    private Graph graph;
    private int startVertex;

    private static final int INFINITY = -1;
    private boolean[] marked;  //is there an s-v path
    private int[] edgeTo;   //previous edge on shortest s-v path
    private int[] distTo;   //number of edges shortest s-v path

    //int source - start vertex in the maze
    public BreadthFirstSearch(Graph g) {
        marked = new boolean[g.getVerticesAmount()];
        distTo = new int[g.getVerticesAmount()];
        edgeTo = new int[g.getVerticesAmount()];
        graph = g;
        startVertex = g.getStartVertex();
        bfs();
    }

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

    public ArrayList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        LinkedList<Integer> path = new LinkedList<>();
        for (int x = v; distTo[x] != 0; x = edgeTo[x])
            path.addFirst(x);
        path.addFirst(startVertex);
        return new ArrayList<>(path);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
