package processors;

import graph.Graph;

import java.util.ArrayList;

public class PathDescriptor {
    public String describe(Graph maze, ArrayList<Integer> path) {
        StringBuilder sb = new StringBuilder();
        if (path == null) {
            sb.append("no path found");
        } else {
            if (maze.getWidth() > 1) {
                for (int i = 0; i < path.size() - 1; i++) {
                    int diff = path.get(i) - path.get(i + 1);
                    if (diff == 1)
                        sb.append("l, ");
                    else if (diff == -1)
                        sb.append("r, ");
                    else if (diff < -1)
                        sb.append("d, ");
                    else
                        sb.append("u, ");

                }
            } else {
                for (int i = 0; i < path.size() - 1; i++) {
                    int diff = path.get(i) - path.get(i + 1);
                    if (diff == 1)
                        sb.append("u, ");
                    else if (diff == -1)
                        sb.append("d, ");

                }
            }
            sb.deleteCharAt(sb.length() - 2);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }
}