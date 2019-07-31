package input;

import java.io.InputStream;

public abstract class AbstractInputReader {

    abstract public String[] readMaze(InputStream source);
}
