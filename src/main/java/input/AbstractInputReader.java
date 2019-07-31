package input;

import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractInputReader {

    abstract public String[] readMaze(InputStream source) throws IOException;
}
