import java.time.Instant;

public class PresentationAdministration {

    Presentation presentation;
    Presentation[] presentations;

    public PresentationAdministration(){

    }

    public void createPresentation(Movie movie, CinemaRoom cinemaRoom, Instant start){
        presentations = Utility.Array_Add(presentations,new Presentation(start, cinemaRoom, movie));
    }
    public Presentation getPresentation(String string, Instant start, CinemaRoom cinemaRoom){
        presentation = Utility.Array_Find(presentations, presentation -> presentation.getMovie().getTitle() == string && presentation.getRoom() == cinemaRoom && presentation.getStart() == start );
        return presentation;
    }
    public void editPresentation(String string, Instant start, CinemaRoom cinemaRoom){

    }
    public void removePresentation(String string, Instant start, CinemaRoom cinemaRoom){

    }

}
