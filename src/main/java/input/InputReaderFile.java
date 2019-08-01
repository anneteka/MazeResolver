package input;

import java.io.*;

/**
 * {@code InputReaderConsole} is an implementation of {@link InputReader} used to read the maze from the console.
 */
public class InputReaderFile implements InputReader {

    /**
     * Reads maze from an {@link InputStream} that is usually {@link FileInputStream}
     * @param source {@link InputStream} that contains the maze as text data
     * @return maze as a String[] where one String equals one actual line of the maze
     */
    @Override
    public String[] readMaze(InputStream source) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(source))) {
            return reader
                    .lines()
                    .toArray(String[]::new);
        }
    }
}
