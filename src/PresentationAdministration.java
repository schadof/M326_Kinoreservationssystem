import java.time.Instant;
import java.util.ArrayList;

public class PresentationAdministration {

    private ArrayList<Presentation> presentations;

    public PresentationAdministration(){
        presentations = new ArrayList<>();
    }

    public void createPresentation(Movie movie, CinemaRoom cinemaRoom, Instant start){
        presentations.add(new Presentation(start, cinemaRoom, movie));
    }

    public ArrayList<Presentation> getAllPresentations(){ return presentations; }

    // This method is rarely useful imo... ~silvan
    public Presentation getPresentation(Movie movie, Instant start, CinemaRoom cinemaRoom){
        return Utility.Array_First(presentations, presentation ->
            presentation.getMovie().equals(movie) &&
            presentation.getRoom().equals(cinemaRoom) &&
            ( // Checks if the instant is during the presentation (start to start+duration)
                    presentation.getStart().equals(start) ||
                    (start.isAfter(presentation.getStart()) && start.isBefore(presentation.getStart().plus(presentation.getMovie().getDuration())))
            ));
    }

    // It is easier to get a presentation and change the result. ~silvan

    public void removePresentation(Presentation target){
        presentations.remove(target);
    }

}
