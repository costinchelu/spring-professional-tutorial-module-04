package module04.question43.data.transfer;

import module04.question43.ds.Person;

import java.util.Arrays;
import java.util.List;

public class PersonTestRepo {

    public static List<Person> getPeople() {
        return Arrays.asList(
                new Person(98, "Test1"),
                new Person(99, "Test2")
        );
    }
}
