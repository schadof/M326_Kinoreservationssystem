import java.time.Duration;

public class Movie {

    String title;
    Duration duration;
    String description;

    public Movie(){

    }

    public String getDescription(){
        return description;
    }
    public String getTitle(){
        return title;
    }
    public Duration getDuration(){
        return duration;
    }
}
