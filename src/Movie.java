import java.time.Duration;

public class Movie {
    private String title;
    private Duration duration;
    private String description;

    public String getDescription(){
        return description;
    }
    public String getTitle(){
        return title;
    }
    public Duration getDuration(){
        return duration;
    }

    // Movie Builder Class
    public class Builder {
        private String _title;
        private Duration _duration;
        private String _description;
        public Builder title(String title){ this._title = title; return this; }
        public Builder duration(Duration duration){ this._duration = duration; return this; }
        public Builder description(String description){ this._description = description; return this; }

        public Builder(){
            _title = "Untitled";
            _duration = Duration.ZERO;
            _description = "No description";
        }
        public Movie Build(){
            Movie movie = new Movie();
            movie.description = _description;
            movie.duration = _duration;
            movie.title = _title;
            return movie;
        }
    }
}
