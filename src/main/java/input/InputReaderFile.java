package input;

import java.io.*;

public class InputReaderFile extends AbstractInputReader {
    private BufferedReader reader;

    public InputReaderFile(String file) {
        try {
            reader = new BufferedReader(new FileReader(new File(file)));
        }
        catch (FileNotFoundException e){
            //todo
        }
    }

    String readMaze() {
        StringBuilder sb = new StringBuilder();
        String line="";
        try {
            line=reader.readLine();
        } catch (IOException e) {
            //todo
        }
        while (line!=null){
            sb.append(line);
            sb.append("|");
            try {
                line=reader.readLine();
            } catch (IOException e) {
                line="";
                e.printStackTrace();
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
