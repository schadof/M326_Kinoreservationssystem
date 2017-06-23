import java.time.Duration;

public class Movie {
    private String title;
    private Duration duration;
    private String description;

    public Movie(String title, Duration duration, String description){
        this.title = title;
        this.duration = duration;
        this.description = description;
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
