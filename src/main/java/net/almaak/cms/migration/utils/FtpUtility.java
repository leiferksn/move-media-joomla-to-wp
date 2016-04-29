package net.almaak.cms.migration.utils;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import sun.net.ftp.FtpProtocolException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * It's a FTP service class that handles FTP operations
 *
 * @author leiferksn
 * @version %I%, %G%
 */
public class FtpUtility {
    // TODO how to pass the ftp address as user input parameter?
    private String ftpResource = null;
    private static FtpUtility instance = null;
    private FTPClient ftpClient = null;
    private static final int CONNECTION_TIMEOUT = 3000;

    public static FtpUtility getInstance(){
        if(instance == null){
            return new FtpUtility();
        }
        return instance;
    }

    private FtpUtility() {
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(ftpResource);
            ftpClient.setConnectTimeout(CONNECTION_TIMEOUT);
        } catch (Exception e) {
            // TODO set different messages for the different types of exceptions - host not found, etc.
            throw new RuntimeException(e);
        }
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
        } catch (FtpProtocolException fpe) {
            // TODO do some exception handling here
        } catch (IOException ioe) {
            // TODO do some exception handling here
        }
        return fileList;
    }
}
