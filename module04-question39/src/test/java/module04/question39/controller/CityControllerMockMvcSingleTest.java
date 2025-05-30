package module04.question39.controller;

import module04.question39.dao.CityDao;
import module04.question39.ds.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerMockMvcSingleTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CityDao cityDao;

    @Test
    public void shouldSaveCity() throws Exception {
        mvc.perform(
                put("/cities")
                        .content("{ \"name\": \"Los Angeles\" }")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        verify(cityDao).save(new City(null, "Los Angeles"));
    }

    @Test
    public void shouldFetchCities() throws Exception {
        when(cityDao.findAll())
                .thenReturn(Arrays.asList(
                        new City(1, "Los Angeles"),
                        new City(2, "New York")
                ));

        String jsonResponse = mvc.perform(get("/cities"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(jsonResponse)
                .contains("{\"id\":1,\"name\":\"Los Angeles\"}")
                .contains("{\"id\":2,\"name\":\"New York\"}");
    }
}
