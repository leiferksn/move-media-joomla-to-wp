package utils;

import net.almaak.cms.migration.utils.FtpUtility;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.security.MessageDigest;

@Ignore
public class FtpUtilityTest {


    @Test
    public void shouldReturnDirectoryList(){
        // still TODO
    }

    @Test
    public void shouldReturnFile() throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String filePath = "images/smog/smog_m.png";
        byte[] shouldBytes = retrieveBytesFromResource(filePath);
        String checksumShould = createFileChecksum(md, shouldBytes);

        FtpUtility ftpUtility = new FtpUtility("xoxoxo");
        byte[] bytes = ftpUtility.retrieveFileFromFtpResource(filePath);
        String checksumIs = createFileChecksum(md, bytes);

        Assert.assertNotNull(bytes);
        Assert.assertEquals(checksumIs, checksumShould);
    }

    private String createFileChecksum(MessageDigest md, final byte[] inputBytes) throws IOException {
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
