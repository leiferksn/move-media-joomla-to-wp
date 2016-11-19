package utils;

import net.almaak.cms.migration.utils.FtpUtility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.security.MessageDigest;
import java.util.Properties;

public class FtpUtilityTest {

    private Properties properties;

    @Before
    public void init() throws IOException {
        properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("test.properties"));
    }

    @Test
    public void shouldReturnDirectoryList(){
        // still TODO
    }

    @Test
    public void shouldReturnFile() throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] shouldBytes = retrieveBytesFromResource(properties.getProperty("test.local.file"));
        String checksumShould = createFileChecksum(md, shouldBytes);

        FtpUtility ftpUtility = new FtpUtility(properties.getProperty("test.ftp.server"),
                properties.getProperty("test.ftp.un"), properties.getProperty("test.ftp.pw"));
        byte[] bytes = ftpUtility.retrieveFileFromFtpResource(properties.getProperty("test.ftp.file"));
        ftpUtility.destroyConnection();
        String checksumIs = createFileChecksum(md, bytes);

        Assert.assertNotNull(bytes);
        Assert.assertEquals(checksumIs, checksumShould);
    }

    private String createFileChecksum(MessageDigest md, final byte[] inputBytes) throws IOException {
        if(inputBytes == null) {
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(inputBytes);
        byte[] chunk = new byte[2048];
        int byteCount = 0;

        while((byteCount = bis.read(chunk)) != -1) {
            md.update(chunk, 0, byteCount);
        }

        bis.close();;

        byte[] bytes = md.digest();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)).substring(1);
        }

        return sb.toString();
    }

    private byte[] retrieveBytesFromResource(String filePath) throws IOException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(filePath);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int read = 0;
        byte[] buffer = new byte[2048];
        while((read = is.read(buffer)) != -1) {
            if(read != -1) {
                out.write(buffer, 0, read);
            }
        }
        out.close();
        return out.toByteArray();
    }
}
