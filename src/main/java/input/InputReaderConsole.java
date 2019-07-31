package input;

import java.util.Scanner;

public class InputReaderConsole extends AbstractInputReader {
    private Scanner scanner;

    public InputReaderConsole() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String[] readMaze() {

        System.out.print("Enter the number of lines in the maze: ");
        int linesAmount = Integer.parseInt(scanner.nextLine());
        String[] lines = new String[linesAmount];
        System.out.println("Enter the maze: ");
        for (int i = 0; i < linesAmount; i++) {
            lines[i]=scanner.nextLine();
        }
        return lines;
    }

}
