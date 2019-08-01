package input;

import java.io.*;

public class InputReaderFile extends AbstractInputReader {
    @Override
    public String[] readMaze(InputStream source) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(source))) {
            return reader
                    .lines()
                    .toArray(String[]::new);
        }
    }
}
