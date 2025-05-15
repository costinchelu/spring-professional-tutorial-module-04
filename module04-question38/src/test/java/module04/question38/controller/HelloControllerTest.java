package module04.question38.controller;

import module04.question38.service.NameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.junit.runner.RunWith;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For JUnit 5, we are not using Runners
 * We will use @ExtendWith(SpringExtension.class), but that is already contained in @SpringBootTest annotation
 */

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NameService nameService;

    @Test
    public void shouldSayHello() throws Exception {

        when(nameService.getName())
                .thenReturn("Test");

        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/"))
                .andReturn();

        assertEquals("Hello Test", mvcResult.getResponse().getContentAsString());
    }
}