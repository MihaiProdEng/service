package ro.unibuc.hello.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProgramareEntityTest
{

    ProgramareEntity myProgramare = new ProgramareEntity("1", "2", "2019-12-06 07:03:00", "casa Foster");

    @Test
    void getData()
    {
        Assertions.assertEquals("2019-12-06 07:03:00", myProgramare.getData());
    }

    @Test
    void getLoc()
    {
        Assertions.assertEquals("casa Foster", myProgramare.getLoc());
    }
}