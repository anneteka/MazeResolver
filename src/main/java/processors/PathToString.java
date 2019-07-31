package processors;

import java.util.ArrayList;

public class PathToString {
    static String pathToString(ArrayList<Integer> path) {

        StringBuilder sb = new StringBuilder();
        if (path == null) {
            sb.append("no path found");
        } else {
            for (int i = 0; i < path.size() - 1; i++) {
                int diff = path.get(i) - path.get(i + 1);
                if (diff == 1)
                    sb.append("r, ");
                else if (diff == -1)
                    sb.append("l, ");
                else if (diff < -1)
                    sb.append("u, ");
                else
                    sb.append("d, ");

            }
            sb.deleteCharAt(sb.length() - 2);
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();

    }
}
