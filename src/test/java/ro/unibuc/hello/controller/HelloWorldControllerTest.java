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
import ro.unibuc.hello.data.AccountEntity;
import ro.unibuc.hello.dto.Greeting;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class HelloWorldControllerTest
{
    @InjectMocks
    private HelloWorldController helloWorldController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void test_sayHello() throws Exception
    {
        // Arrange
        Greeting greeting = new Greeting(1, "Hello, Test!");

        // Act
        MvcResult result = mockMvc.perform(get("/hello-world?name=Test")
                        .content(objectMapper.writeValueAsString(greeting))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(greeting));
    }

    @Test
    void test_addAccount() throws Exception
    {
        // Arrange
        AccountEntity myAccount = new AccountEntity("marius26", "1234");

        // Act
        MvcResult result = mockMvc.perform(get("/addAccount?name=marius26&password=1234")
                        .content(objectMapper.writeValueAsString(myAccount))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals("Name allready in use", objectMapper.writeValueAsString(myAccount));
    }

//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void shouldPassIfStringMatches() throws Exception
//    {
//        assertThat(restTemplate.getForObject("http://localhost:8090/allAccounts",
//                String.class)).contains("[Account[id='622ce4cad8eedb3a34bcf4f0', name='marius26', password='1234'], Account[id='622ce9c97591332dabf41148', name='mamata', password='1234']]");
//    }
}