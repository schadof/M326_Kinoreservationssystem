import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.HOURS;

public class Main {
    public static void main(String[] args) {
        CinemaManagement cinemaManagement = new CinemaManagement();
        Movie movie = new Movie("Test", Duration.of(2, HOURS),"This is a test");
        cinemaManagement.getMovieAdmin().addMovie(movie);
        ClientAdministration clientAdministration = new ClientAdministration();
        Client client = new Client("Lars","1234567","Test@test.ch","Zuhause");
        clientAdministration.addClient(client);
        System.out.println(cinemaManagement.getMovieAdmin().getAllMovies().get(0).getTitle());
        System.out.println(clientAdministration.getClientByName("Lars").getAddress());
        PresentationAdministration presentationAdministration = new PresentationAdministration();
        RoomAdministration roomAdministration = new RoomAdministration();
        ArrayList<Row> rows = new ArrayList<>();
        ArrayList<Seat> seats = new ArrayList<>();
        Seat seat = new Seat();
        seats.add(seat);
        rows.add(new Row(seats));
        roomAdministration.createRoom(rows);
        CinemaRoom cinemaRoom = new CinemaRoom(rows);
        Presentation presentation = new Presentation(Instant.now(), cinemaRoom, movie);

        presentationAdministration.createPresentation(movie, cinemaRoom, Instant.now());
        Reservation reservation = new Reservation(client, presentation, seat);
        System.out.println(reservation.getClient().getMail());
        System.out.println(reservation.getSeat().getNumber());
    }
}
