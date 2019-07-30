package input;

import java.util.Scanner;

public class InputReaderConsole extends AbstractInputReader {
    private Scanner scanner;

    public InputReaderConsole() {
        scanner = new Scanner(System.in);
    }

    String readMaze() {
        StringBuilder sb = new StringBuilder();
        System.out.print("Enter the number of lines in the maze: ");
        int lines = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the maze: ");
        for (int i = 0; i < lines; i++) {
            sb.append(scanner.nextLine());
            sb.append("|");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
