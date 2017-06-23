import java.time.Instant;

public class PresentationAdministration {

    private Presentation[] presentations;

    public PresentationAdministration(){
        presentations = new Presentation[0];
    }

    public void createPresentation(Movie movie, CinemaRoom cinemaRoom, Instant start){
        presentations = Utility.Array_Add(presentations,new Presentation(start, cinemaRoom, movie));
    }

    public Presentation[] getAllPresentations(){ return presentations; }

    // This method is rarely useful imo... ~silvan
    public Presentation getPresentation(Movie movie, Instant start, CinemaRoom cinemaRoom){
        Presentation result = Utility.Array_Find(presentations,
                presentation ->
                        presentation.getMovie() == movie &&
                        presentation.getRoom() == cinemaRoom &&
                        presentation.getStart() == start );
        return result;
    }

    // It is easier to get a presentation and change the result. ~silvan

    public void removePresentation(Presentation target){ //It is easier to simply provide the presentation itself ~silvan
        presentations = Utility.Array_Remove(presentations, target);
    }

}
