package graph;

public class BreadthFirstSearch {
    //calculates the shortest possible path

    private static final int INFINITY = -1;
    private boolean[] marked;  //is there an s-v path
    private int[] edgeTo;   //previous edge on shortest s-v path
    private int[] distTo;   //number of edges shortest s-v path

    //int source - start vertex in the maze
    public BreadthFirstSearch(Graph g, int source){
        marked = new boolean[g.getVertices()];
        distTo = new int[g.getVertices()];
        edgeTo = new int[g.getVertices()];
    }
}
