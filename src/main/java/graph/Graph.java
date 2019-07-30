package graph;

import java.util.ArrayList;

public class Graph {
    //contains information about the maze as graph

    private int vertices; //amount of vertices
    private int edges; //amount of edges
    private int startVertex, finishVertex;
    private ArrayList<Integer>[] adj; //list of all adjacent vertices

    //data string contains all information about the graph
    //and has the structure as below
    //vertices_amount edges_amount start_vertex finish_vertex vertex-vertex ... pairs of linked vertices
    public Graph(String data) {
        String[] graph = data.split(" ");
        vertices = Integer.parseInt(graph[0]);
        adj = new ArrayList[vertices];
        startVertex = Integer.parseInt(graph[graph.length - 2]);
        finishVertex = Integer.parseInt(graph[graph.length - 1]);
        edges = graph.length - 3;
        String[] verticesPair;
        for (int i = 1; i < graph.length - 2; i++) {
            verticesPair = graph[i].split("-");
            adj[Integer.parseInt(verticesPair[0])].add(Integer.parseInt(verticesPair[1]));
        }
    }


}
