package module04.question43.data.transfer;

import module04.question43.data.layer.FtpDataLayer;
import module04.question43.data.layer.HttpDataLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTransferActionManualMockInjectionTest {

    @Autowired
    private DataTransferAction dataTransferAction;

    @Mock
    private FtpDataLayer ftpDataLayer;

    @Mock
    private HttpDataLayer httpDataLayer;

    @Before
    public void setUp() {
        dataTransferAction.setFtpDataLayer(ftpDataLayer);
        dataTransferAction.setHttpDataLayer(httpDataLayer);
    }

    @Test
    public void shouldTransferDataFromFtpToHttp() {
        when(ftpDataLayer.getData()).thenReturn(PersonTestRepo.getPeople());
        dataTransferAction.transfer();
        verify(httpDataLayer).saveData(PersonTestRepo.getPeople());
    }
}