package input;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputReaderConsole extends AbstractInputReader {

    @Override
    public String[] readMaze(InputStream source) {
        try (var scanner = new Scanner(source)) {
            System.out.print("Enter the number of lines in the maze: ");
            String[] lines = new String[parseInt(scanner.nextLine())];
            System.out.println("Enter the maze: ");
            for (int i = 0; i < lines.length; i++) {
                lines[i] = scanner.nextLine();
            }
            return lines;
        }
    }
}
