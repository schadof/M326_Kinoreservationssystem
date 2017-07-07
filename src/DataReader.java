import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class DataReader {

    //singleton instance
    private static DataReader instance;

    //
    public static DataReader getInstance(){
        if (instance == null)
            instance = new DataReader();
        return instance;
    }
    private DataReader() { }

    public ArrayList<Client> readClients(){return readClients("clients.txt");}
    public ArrayList<Client> readClients(String filename){
        ArrayList<String> content = read(filename);
        ArrayList<Client> result = new ArrayList<>();
        for (String line  : content) {
            ArrayList<String> parts = Utility.Array_ToList(line.split(";"));
            result.add(
                    new Client(
                            parts.get(0), //name
                            parts.get(1), //number
                            parts.get(2), //mail
                            parts.get(3)) //address
            );
        }
        return result;
    }
    public ArrayList<Movie> readMovies(){return readMovies("movies.txt");}
    public ArrayList<Movie> readMovies(String filename){
        ArrayList<String> content = read(filename);
        ArrayList<Movie> result = new ArrayList<>();
        for (String line  : content) {
            ArrayList<String> parts = Utility.Array_ToList(line.split(";"));
            result.add(
                    new Movie(
                            parts.get(0), // Title
                            Duration.ofMinutes(Long.parseLong(parts.get(1))), // Duration in Minutes
                            parts.get(2)) // Description
            );
        }
        return result;
    }
    public ArrayList<CinemaRoom> readRooms(){return readRooms("rooms.txt");}
    public ArrayList<CinemaRoom> readRooms(String filename){
        ArrayList<String> content = read(filename);
        ArrayList<CinemaRoom> result = new ArrayList<>();
        for (String line  : content) {
            ArrayList<String> parts = Utility.Array_ToList(line.split(";"));
            ArrayList<Row> rows = new ArrayList<>();
            for (String part: parts) rows.add(new Row(Integer.parseInt(part)));
            result.add( new CinemaRoom(rows));
        }
        return result;
    }

    private ArrayList<String> read(String filename) {
        ArrayList<String> result = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) result.add(line);
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File could not be found:\n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Unable to read file:\n" + ex.getMessage());
        }
        return result;
    }
}