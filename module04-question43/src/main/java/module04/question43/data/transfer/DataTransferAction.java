package module04.question43.data.transfer;

import lombok.Getter;
import lombok.Setter;
import module04.question43.data.layer.FtpDataLayer;
import module04.question43.data.layer.HttpDataLayer;
import module04.question43.ds.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class DataTransferAction {

    @Autowired
    private FtpDataLayer ftpDataLayer;

    @Autowired
    private HttpDataLayer httpDataLayer;

    public void transfer() {
        List<Person> personData = ftpDataLayer.getData();
        httpDataLayer.saveData(personData);
    }
}
