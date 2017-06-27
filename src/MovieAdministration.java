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
        for(Movie movie : movies) {
            if(movie.getTitle().equals(title)){
                return movie;
            }
        }
        return null;
    }

}
