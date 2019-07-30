package processors;

import graph.Graph;

public class InputProcessor {
    //processes data from input readers and forms a graph
    public static Graph createGraph(String data) {
        return new Graph(process(data));
    }

    //returns string that contains all information about the graph
    //and has the structure as below
    //vertices_amount start_vertex finish_vertex vertex-vertex ... pairs of linked vertices
    public static String process(String data) {
        String[] maze=data.split("\\|");
        StringBuilder graph = new StringBuilder();
        graph.append(maze[0].length()*maze.length);
        int startVertex, finishVertex;
        int current;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length(); j++) {
                current=i*maze.length+j;
                if (current=='S'){
                    startVertex=current;
                }
                if (current=='F'){
                    finishVertex=current;
                }
                if (current=='.'){
                    if (i>0&&maze[i-1].charAt(j)=='.') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current-maze.length);
                    }
                    if (i<maze.length-1&&maze[i+1].charAt(j)=='.') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current+maze.length);
                    }
                    if (j>0&&maze[i].charAt(j-1)=='.') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current-1);
                    }
                    if (j<maze[i].length()-1&&maze[i].charAt(j+1)=='.') {
                        graph.append(current);
                        graph.append('-');
                        graph.append(current+1);
                    }
                }
            }
        }
        return graph.toString();
    }
}
