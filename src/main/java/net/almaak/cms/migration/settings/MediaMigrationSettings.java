package net.almaak.cms.migration.settings;

import java.net.URL;

/**
 * Holds sepcific settings for migration of media resources - images, videos etc.
 *
 * @author leiferksn
 * @version %I%, %G%
 */
public class MediaMigrationSettings extends MigrationSettings {

    private boolean fromFileSystem = true;
    private boolean remote = false;
    private URL resourcesURL = null;
    private long batchSize = 10L;   // how many resources should be migrated in one go

    public void setFromFileSystem(boolean aFromFileSystem){
        this.fromFileSystem = aFromFileSystem;
    }

}
