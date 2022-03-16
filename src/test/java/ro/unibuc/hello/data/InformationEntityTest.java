package ro.unibuc.hello.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.InformationEntity;


class InformationEntityTest
{
    InformationEntity myInfo = new InformationEntity("Title", "description");

    @Test
    void testToString()
    {
        Assertions.assertEquals("Information[id='null', title='Title', description='description']", myInfo.toString());
    }
}