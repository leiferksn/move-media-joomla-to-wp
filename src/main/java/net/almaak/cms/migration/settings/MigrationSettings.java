package net.almaak.cms.migration.settings;

/**
 * Holds the basic settings for a migration
 *
 * @author leiferksn
 * @version %I%, %G%
 */

public class MigrationSettings {

    // initialization-on-demand holder idiom, thread safe
    // https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
    // instead of calling the constructor without a parameters,
    // a constructor with parameters in the Holder can be called

    private static class Holder {
        static final MigrationSettings instance = new MigrationSettings();
    }

    private static MigrationSettings instance = null;

    private String ftpServer;
    private String ftpUsername;
    private String ftpPassword;

    public static MigrationSettings getInstance() {
        return Holder.instance;
    }

    private void MigrationSettings () {
        // private constructor
    }

    public String getFtpUsername() {
        return ftpUsername;
    }

    public String getFtpPassword() {
        return ftpPassword;
    }

    public String getFtpServer() {
        return ftpServer;
    }

}
