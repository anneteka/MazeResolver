package graph;

import java.util.ArrayList;

public class Graph {
    //contains information about the maze as graph

    private int vertices; //amount of vertices
    private int edges; //amount of edges
    private int startVertex, finishVertex;
    private int height, width;
    private ArrayList<Integer>[] adj; //list of all adjacent vertices

    //data string contains all information about the graph
    //and has the structure as below
    //vertices_amount vertex-vertex ... pairs of linked vertices height width start_vertex finish_vertex
    public Graph(int verticesAmount, int height, int width, int edgesAmount,
                 int startVertex, int finishVertex, ArrayList<Integer>[] adjacent) {
        vertices = verticesAmount;
        adj = adjacent;
        this.startVertex = startVertex;
        this.finishVertex = finishVertex;
        edges = edgesAmount;
        this.height = height;
        this.width = width;
    }


    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public int getStartVertex() {
        return startVertex;
    }

    public int getFinishVertex() {
        return finishVertex;
    }

    public ArrayList<Integer>[] getAdj() {
        return adj;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(vertices);
        sb.append(' ');
        for (int i = 0; i < adj.length; i++) {
            for (int vertex : adj[i]) {
                sb.append(i);
                sb.append('-');
                sb.append(vertices);
                sb.append(' ');
            }
        }
        sb.append(startVertex);
        sb.append(' ');
        sb.append(finishVertex);
        return sb.toString();
    }

}
