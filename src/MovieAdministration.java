public class MovieAdministration {

    Movie[] movies;

    public MovieAdministration(){
        movies = new Movie[0];
    }

    public Movie[] getAllMovies(){ return movies; }

    public void addMovie(Movie movie){movies = Utility.Array_Add(movies, movie);}

}
