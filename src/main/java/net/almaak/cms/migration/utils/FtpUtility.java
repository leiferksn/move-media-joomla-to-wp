package net.almaak.cms.migration.utils;


import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import net.almaak.cms.migration.settings.MediaMigrationSettings;
import net.almaak.cms.migration.settings.MigrationSettings;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import sun.net.ftp.FtpProtocolException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * It's a FTP service class that handles FTP operations
 *
 * @author leiferksn
 * @version %I%, %G%
 */
public class FtpUtility {
    private FTPClient ftpClient = null;
    private static final int CONNECTION_TIMEOUT = 3000;

    public FtpUtility(String ftpServer, String userName, String passWord) {
        try {
            ftpClient = new FTPClient();
            ftpClient.setDefaultPort(21);
            ftpClient.connect(ftpServer);
            ftpClient.login(userName, passWord);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setConnectTimeout(CONNECTION_TIMEOUT);
        } catch (Exception e) {
            // TODO set different messages for the different types of exceptions - host not found, etc.
            throw new RuntimeException(e);
        }
    }

    public byte[] retrieveFileFromFtpResource(final String ftpPath) throws IOException {
        byte[] fileBytes = null;
        // String downloadedFile = "/tmp/downloadedFile" + Integer.toString(ftpPath.hashCode();
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        boolean ok = ftpClient.retrieveFile(ftpPath, fos);
        fos.close();
        if (ok) {
            fileBytes = fos.toByteArray();
        }
        return fileBytes;
    }

    public void destroyConnection() throws IOException {
        ftpClient.logout();
        ftpClient.disconnect();
    }

    public List<String> retrieveFileListFromFtpResource(String ftpPath) {
        List<String> fileList = null;
        try {
            if (!ftpClient.isConnected()) {
            // TODO implement reconnect
            }
            FTPFile[] ftpFiles =  ftpClient.listFiles(ftpPath);
            fileList = new ArrayList<String>();
            for(FTPFile ftpFile : ftpFiles){
                int type = ftpFile.getType();
                if(type == 0) {
                    fileList.add(ftpFile.getName());
                }
            }
        } catch (IOException ioe) {
            // TODO do some exception handling here
        }
        return fileList;
    }
}
