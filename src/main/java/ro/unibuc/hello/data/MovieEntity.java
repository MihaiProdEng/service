package ro.unibuc.hello.data;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Component
public class MovieEntity
{
    @Id
    public String id;

    @Column(unique = true)
    public String movieName;
    public Date startTime;

    public MovieEntity() {}

    public MovieEntity(String movieName, Date startTime)
    {
        this.movieName = movieName;
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public Date getStartTime() {
        return startTime;
    }
}
