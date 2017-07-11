import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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

            for (int i = 1 ; i < parts.size(); i++) {
                String part = parts.get(i);
                rows.add(new Row(Integer.parseInt(part)));
            }

            result.add( new CinemaRoom(parts.get(0), rows));
        }
        return result;
    }
    public ArrayList<Presentation> readPresentations(){return readPresentations("presentations.txt");}
    public ArrayList<Presentation> readPresentations(String filename) { return readPresentations(filename, "rooms.txt", "movies.txt"); }
    public ArrayList<Presentation> readPresentations(String filename, String roomsFilename, String moviesFilename){
        ArrayList<String> content = read(filename);
        ArrayList<Presentation> result = new ArrayList<>();
        for (String line  : content) {
            ArrayList<String> parts = Utility.Array_ToList(line.split(";"));
            result.add(new Presentation(
                    Instant.parse(parts.get(0)), // Date and Time
                    Utility.Array_First(readRooms(roomsFilename), cinemaRoom -> cinemaRoom.getID().equals(parts.get(1))), // Room ID
                    Utility.Array_First(readMovies(moviesFilename), movie -> movie.getTitle().equals(parts.get(2))) // Movie name
            ));
        }
        return result;
    }

    public ArrayList<Reservation> readReservations(){return readReservations("reservations.txt");}
    public ArrayList<Reservation> readReservations(String filename){
        return readReservations(
                "reservations.txt",
                "clients.txt",
                "presentations.txt",
                "rooms.txt",
                "movies.txt");
    }
    public ArrayList<Reservation> readReservations(String filename, String clientFilename, String presentationFilename, String roomFilename, String moviesFilename){
        ArrayList<String> content = read(filename);
        ArrayList<Reservation> result = new ArrayList<>();
        for (String line  : content) {
            ArrayList<String> parts = Utility.Array_ToList(line.split(";"));
            Client clt = Utility.Array_First(readClients(clientFilename), client -> client.getName().equals(parts.get(0)));
            Presentation pres = Utility.Array_First(readPresentations(presentationFilename, roomFilename, moviesFilename),
                    presentation ->
                            presentation.getRoom().getID().equals(parts.get(1)) && // Room ID
                                    presentation.getMovie().getTitle().equals(parts.get(2)) && // Movie Title
                                    presentation.getStart().equals(Instant.parse(parts.get(3)))); // Presentation Time
            Seat seat = pres.getRoom().getAllRows().get(Integer.parseInt(parts.get(4))-1) // Row Number
                    .getSeats().get(Integer.parseInt(parts.get(5))-1); // Column/Seat Number
            result.add( new Reservation( clt, pres, seat) );
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