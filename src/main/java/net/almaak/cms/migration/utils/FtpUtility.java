package net.almaak.cms.migration.utils;


import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.FileMode;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.transport.verification.HostKeyVerifier;
import net.schmizz.sshj.xfer.InMemoryDestFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * It's a FTP service class that handles FTP operations
 *
 * @author leiferksn
 * @version %I%, %G%
 */
public class FtpUtility {
    private SSHClient ftpClient = null;
    private static final int CONNECTION_TIMEOUT = 3000;
    private class NullHostKeyVerifier implements HostKeyVerifier {
        @Override
        public boolean verify(String arg0, int arg1, PublicKey arg2) {
            return true;
        }
    }

    private class InMemoryFile extends InMemoryDestFile {
        private ByteArrayOutputStream bos = new ByteArrayOutputStream();

        @Override
        public OutputStream getOutputStream() throws IOException {
            return bos;
        }
    }

    public FtpUtility(String ftpServer, String userName, String passWord) {
        try {
            ftpClient = new SSHClient();
            ftpClient.addHostKeyVerifier(new NullHostKeyVerifier());
            ftpClient.connect(ftpServer);
            ftpClient.authPassword(userName, passWord);
            ftpClient.setConnectTimeout(CONNECTION_TIMEOUT);
        } catch (Exception e) {
            // TODO set different messages for the different types of exceptions - host not found, etc.
            throw new RuntimeException(e);
        }
    }

    public byte[] retrieveFileFromFtpResource(final String ftpPath) throws IOException {
        byte[] fileBytes = null;
        // String downloadedFile = "/tmp/downloadedFile" + Integer.toString(ftpPath.hashCode();
        InMemoryDestFile inMemoryDestFile = new InMemoryFile();
        // ForceCommand internal-sftp in the config limits users to use sftp only.
        ftpClient.newSFTPClient().get(ftpPath, inMemoryDestFile);
        if (inMemoryDestFile != null) {
            fileBytes = ((ByteArrayOutputStream)inMemoryDestFile.getOutputStream()).toByteArray();
        }
        inMemoryDestFile.getOutputStream().close();
        return fileBytes;
    }

    public void destroyConnection() throws IOException {
        ftpClient.disconnect();
    }

    public List<String> retrieveFileListFromFtpResource(String ftpPath) {
        List<String> fileList = null;
        try {
            if (!ftpClient.isConnected()) {
            // TODO implement reconnect
            }
            List<RemoteResourceInfo> ftpFiles =  ftpClient.newSFTPClient().ls(ftpPath);
            fileList = new ArrayList<String>();
            for(RemoteResourceInfo ftpFile : ftpFiles){
                FileMode.Type type = ftpFile.getAttributes().getType();
                if(type.equals(FileMode.Type.REGULAR)) {
                    fileList.add(ftpFile.getName());
                }
            }
        } catch (IOException ioe) {
            // TODO do some exception handling here
        }
        return fileList;
    }
}
