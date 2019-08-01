package input;

import java.io.InputStream;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * {@code InputReaderConsole} is an implementation of {@link InputReader} used to read the maze from the console.
 */
public class InputReaderConsole implements InputReader {

    /**
     * Reads maze from an {@link InputStream} that is System.in
     * @param source {@link InputStream} that contains the maze as text data
     * @return maze as a String[] where one String equals one actual line of the maze
     */
    @Override
    public String[] readMaze(InputStream source) {
        try (var scanner = new Scanner(source)) {
            System.out.print("Enter the number of lines in the maze: ");
            var lines = new String[parseInt(scanner.nextLine())];
            System.out.println("Enter the maze: ");
            for (int i = 0; i < lines.length; i++) {
                lines[i] = scanner.nextLine();
            }
            return lines;
        }
    }
}
