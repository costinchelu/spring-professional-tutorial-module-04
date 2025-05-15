package module04.question39.controller;

import module04.question39.ds.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@JsonTest
public class CityJsonTest {

    @Autowired
    private JacksonTester<City> json;

    private final String jsonString = "{\"id\":1,\"name\":\"New York\"}";

    @Test
    public void shouldSerialize() throws IOException {
        City city = new City(1, "New York");

        String json = this.json.write(city).getJson();

        assertEquals(jsonString, json);
    }

    @Test
    public void shouldDeserialize() throws IOException {
        City city = json.parse(jsonString).getObject();

        assertEquals(valueOf(1), city.getId());
        assertEquals("New York", city.getName());
    }
}
