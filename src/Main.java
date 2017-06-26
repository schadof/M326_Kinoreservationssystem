import java.time.Duration;

import static java.time.temporal.ChronoUnit.HOURS;

public class Main {
    public static void main(String[] args) {
        CinemaManagement cinemaManagement = new CinemaManagement();
        Movie movie = new Movie("Test", Duration.of(2, HOURS),"This is a test");
        cinemaManagement.getMovieAdmin().addMovie(movie);
        System.out.println(cinemaManagement.getMovieAdmin().getAllMovies());
    }
}
