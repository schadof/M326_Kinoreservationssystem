import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONReader {

    String file = "films.json";

    public JSONReader(String fileName) {
        file = fileName;
    }

    //one line at a time
    String line = null;

    //hashmap
    ArrayList<String> string = new ArrayList<String>();

    public ArrayList<String> read() {
        try {
            //initialize reader standard encoding
            FileReader fileReader = new FileReader(file);

            //Wrap FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                //putin array
            }

            //Closes BufferedReader
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File could not be found");
        } catch (IOException ex) {
            System.out.println("Unable to read file");
        }
        return string;
    }
}