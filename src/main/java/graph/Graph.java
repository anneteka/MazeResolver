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
    public Graph(String data) {
        String[] graph = data.split(" ");
        vertices = Integer.parseInt(graph[0]);
        adj = new ArrayList[vertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        startVertex = Integer.parseInt(graph[graph.length - 2]);
        finishVertex = Integer.parseInt(graph[graph.length - 1]);
        edges = graph.length - 5;
        height = Integer.parseInt(graph[graph.length - 4]);
        width = Integer.parseInt(graph[graph.length - 3]);
        String[] verticesPair;
        for (int i = 1; i < graph.length - 4; i++) {
            verticesPair = graph[i].split("-");
            adj[Integer.parseInt(verticesPair[0])].add(Integer.parseInt(verticesPair[1]));
        }
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
