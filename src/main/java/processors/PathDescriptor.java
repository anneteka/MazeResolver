package processors;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Reformat the path found with {@link graph.BreadthFirstSearch} as the set of instructions.
 */
public class PathDescriptor {

    /**
     * Reformat the path found with {@link graph.BreadthFirstSearch} as the set of instructions.
     * @param graphWidth if the width is 1, then only up and down moves are allowed
     * @param pathOptional the path that should be reformatted
     * @return the final set of steps needed for the maze to be solved
     */
    public String describe(int graphWidth, Optional<ArrayList<Integer>> pathOptional) {
        var sb = new StringBuilder();
        if (!pathOptional.isPresent()) {
            sb.append("no path found");
        } else {
            ArrayList<Integer> path = pathOptional.get();
            if (graphWidth > 1) {
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
                    else
                        sb.append("d, ");
                }
            }
            sb.deleteCharAt(sb.length() - 2);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }
}
