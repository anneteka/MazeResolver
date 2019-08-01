package input;

import java.io.IOException;
import java.io.InputStream;

/**
 * {@code InputReader} is an object that is able to read the data for the {@link graph.Graph}
 * from the {@link InputStream} with the readMaze() method.
 */
public interface InputReader {

    /**
     *
     * @param source an {@link InputStream} that contains the maze as text data
     * @return maze as a String[] where one String equals one actual line of the maze
     * @throws IOException
     */
    String[] readMaze(InputStream source) throws IOException;
}
