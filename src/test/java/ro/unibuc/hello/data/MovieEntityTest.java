package ro.unibuc.hello.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.MovieEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class MovieEntityTest
{
    public Date StringToDate(String s)
    {
        Date result = null;

        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }

        return result ;
    }

    Date date = StringToDate("2015-12-06 17:03:00");

    MovieEntity myMovie = new MovieEntity("Star Wars", date);

    @Test
    void testgetId()
    {
        Assertions.assertNull(myMovie.getId());
    }

    @Test
    void testgetMovieName()
    {
        Assertions.assertEquals("Star Wars", myMovie.getMovieName());
    }

    @Test
    void testgetStartTime()
    {
        Assertions.assertEquals(date, myMovie.getStartTime());
    }

}