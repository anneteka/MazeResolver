package input;

import java.io.*;

public class InputReaderFile extends AbstractInputReader {
    private BufferedReader reader;

    public InputReaderFile(String file) {
        try {
            reader = new BufferedReader(new FileReader(new File(file)));
        } catch (FileNotFoundException e) {
            //todo
            e.printStackTrace();
        }
    }

    @Override

    public String[] readMaze() {
        return reader.lines().toArray(String[]::new);
    }

}
