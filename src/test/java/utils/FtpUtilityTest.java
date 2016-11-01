package utils;

import net.almaak.cms.migration.utils.FtpUtility;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class FtpUtilityTest {


    @Test
    public void shouldReturnDirectoryList(){
        // still to do
    }

    @Test
    public void shouldReturnFile() {
        FtpUtility ftpUtility = FtpUtility.getInstance();
        String filePath = "images/smog/smog_m.png";
        byte[] bytes = ftpUtility.retrieveFileFromFtpResource(filePath);

        Assert.assertNotNull(bytes);
    }
}
