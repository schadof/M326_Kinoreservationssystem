import java.util.ArrayList;

public class MovieAdministration {

    private ArrayList<Movie> movies;

    public MovieAdministration(){
        movies = new ArrayList<>();
    }

    public ArrayList<Movie> getAllMovies(){ return movies; }

    public void addMovie(Movie movie){movies.add(movie);}

    public void removeMove(Movie movie){movies.add(movie);}

    //Certainly useful ~silvan
    public Movie getMovieByName(String title){
        return Utility.Array_First(movies, movie -> movie.getTitle().equals(title));
    }

}
