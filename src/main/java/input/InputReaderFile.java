package input;

import java.io.*;

public class InputReaderFile extends AbstractInputReader {
    private BufferedReader reader;

    @Override

    public String[] readMaze(InputStream source) {
        reader = new BufferedReader(new InputStreamReader(source));
        String[] lines = reader.lines().toArray(String[]::new);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            //todo
        }
        return lines;
    }

}
