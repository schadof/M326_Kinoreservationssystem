import java.time.Duration;
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
    }
}
