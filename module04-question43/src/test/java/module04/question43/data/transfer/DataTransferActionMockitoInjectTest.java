package module04.question43.data.transfer;

import module04.question43.data.layer.FtpDataLayer;
import module04.question43.data.layer.HttpDataLayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataTransferActionMockitoInjectTest {

    @InjectMocks
    private DataTransferAction dataTransferAction;

    @Mock
    private FtpDataLayer ftpDataLayer;

    @Mock
    private HttpDataLayer httpDataLayer;

    @Test
    public void shouldTransferDataFromFtpToHttp() {
        when(ftpDataLayer.getData()).thenReturn(PersonTestRepo.getPeople());
        dataTransferAction.transfer();
        verify(httpDataLayer).saveData(PersonTestRepo.getPeople());
    }
}