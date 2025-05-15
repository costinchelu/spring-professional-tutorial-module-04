package module04.question43.data.transfer;

import module04.question43.data.layer.FtpDataLayer;
import module04.question43.data.layer.HttpDataLayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTransferActionMockBeanTest {

    @Autowired
    private DataTransferAction dataTransferAction;

    @MockBean
    private FtpDataLayer ftpDataLayer;

    @MockBean
    private HttpDataLayer httpDataLayer;

    @Test
    public void shouldTransferDataFromFtpToHttp() {
        when(ftpDataLayer.getData()).thenReturn(PersonTestRepo.getPeople());

        dataTransferAction.transfer();

        verify(httpDataLayer).saveData(PersonTestRepo.getPeople());
    }
}