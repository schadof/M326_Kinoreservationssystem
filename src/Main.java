import java.time.Duration;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;

public class Main {
    public static void main(String[] args) {

        Instant startTime = Instant.now();

        CinemaManagement cinemaManagement = new CinemaManagement();
        cinemaManagement.getMovieAdmin().addMovie(new Movie("Test", Duration.of(2, HOURS),"This is a test"));
        cinemaManagement.getClientAdmin().addClient(new Client("Lars","1234567","Test@test.ch","Zuhause"));
        cinemaManagement.getRoomAdmin().createRoom(Utility.Array_Create(new Row[]{
                new Row(10),
                new Row(20)
        }));
        cinemaManagement.getPresentationAdmin().createPresentation(
                cinemaManagement.getMovieAdmin().getMovieByName("Test"),
                cinemaManagement.getRoomAdmin().getRoom(0),
                startTime);



        int resID = cinemaManagement.getPresentationAdmin()
                .getAllPresentations()
                .get(0)
                .createReservation(
                        cinemaManagement.getRoomAdmin().getRoom(0).getRow(0).get(5),
                        cinemaManagement.getClientAdmin().getClientByName("Lars"));

        Reservation reservation = Reservation.getReservation(resID);

        System.out.println(reservation.getPresentation().getMovie().getTitle());
        System.out.println(reservation.getSeat().getNumber());
        System.out.println(reservation.getClient().getName());
    }
}
