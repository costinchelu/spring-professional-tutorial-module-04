package module04.question43.data.layer;

import module04.question43.ds.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HttpDataLayer {

    public void saveData(List<Person> persons) {
        System.out.println("Saving data to http...");
        persons.forEach(System.out::println);
        System.out.println("Done");
    }
}
