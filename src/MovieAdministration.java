public class MovieAdministration {

    private Movie[] movies;

    public MovieAdministration(){
        movies = new Movie[0];
    }

    public Movie[] getAllMovies(){ return movies; }

    public void addMovie(Movie movie){movies = Utility.Array_Add(movies, movie);}

    public void removeMove(Movie movie){movies = Utility.Array_Remove(movies, movie);}

    //Certainly useful ~silvan
    public Movie getMovieByName(String title){return Utility.Array_Find(movies, movie -> movie.getTitle() == title);}

}
