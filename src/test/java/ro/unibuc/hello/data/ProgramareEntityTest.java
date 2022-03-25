package ro.unibuc.hello.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProgramareEntityTest
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

    Date date = StringToDate("2019-12-06 07:03:00");

    ProgramareEntity myProgramare = new ProgramareEntity("1", "2", date, "casa Foster");

    @Test
    void getData()
    {
        Assertions.assertEquals(date, myProgramare.getData());
    }

    @Test
    void getLoc()
    {
        Assertions.assertEquals("casa Foster", myProgramare.getLoc());
    }
}