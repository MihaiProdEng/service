package ro.unibuc.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.web.bind.annotation.RequestParam;
import ro.unibuc.hello.data.AccountEntity;
import ro.unibuc.hello.data.AccountRepository;
import ro.unibuc.hello.dto.Greeting;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


@SpringBootTest
class HelloWorldControllerTest extends HelloWorldController
{
    @Test
    public void test_addAccount()
    {
        Assertions.assertEquals("Name allready in use", addAccount("marius26", "1234"));
    }

    @Test
    public void test_login_bad()
    {
        Assertions.assertEquals("Invalid name + password combination", login("banana", "69420"));
    }

    @Test
    public void test_login_good()
    {
        Assertions.assertEquals("ESTI LOGAT FRATE", login("marius26", "1234"));
    }

    @Test
    public void test_allAccounts()
    {
        Assertions.assertEquals("[Account[id='622ce4cad8eedb3a34bcf4f0', name='marius26', password='1234'], Account[id='622ce9c97591332dabf41148', name='mamata', password='1234'], Account[id='6245ce362be5406e424c906d', name='Mihai', password='69420']]", allAccounts());
    }

    @Test
    public void test_addMovie()
    {
        Assertions.assertEquals("[]", addMovie("Star Wars", ""));
    }

    @Test
    public void test_deleteMovies()
    {
        Assertions.assertEquals("[]", deleteMovies());
    }

    @Test
    public void test_addProgramare()
    {
        Assertions.assertEquals("[]", addMovie("Mihai", "Star Wars", "", "Suceava"));
    }

    @Test
    public void test_allProgramari()
    {
        Assertions.assertEquals("[]", allProgramari());
    }
}