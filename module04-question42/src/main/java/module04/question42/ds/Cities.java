package module04.question42.ds;

import lombok.NoArgsConstructor;
import module04.question42.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cities {
    private Iterable<City> cities;
}
