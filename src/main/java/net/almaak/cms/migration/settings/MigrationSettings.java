package net.almaak.cms.migration.settings;

/**
 * Holds the basic settings for a migration
 *
 * @author leiferksn
 * @version %I%, %G%
 */

public class MigrationSettings {

    private static MigrationSettings instance = null;

    private String ftpServer;

    public static MigrationSettings getInstance() {
        if(instance == null) {
            instance = new MigrationSettings();
        }
        return instance;
    }

    private void MigrationSettings () {
        // private constructor
    }

    public String getFtpServer() {
        return ftpServer;
    }

    public void setFtpServer(String ftpServer) {
        this.ftpServer = ftpServer;
    }
}
