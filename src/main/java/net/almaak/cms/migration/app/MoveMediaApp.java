package net.almaak.cms.migration.app;

import net.almaak.cms.migration.settings.MediaMigrationSettings;
import net.almaak.cms.migration.settings.MigrationSettings;

/**
 * Entry point class for the migration app
 *
 * @author leiferksn
 * @version %I%, %G%
 */

public class MoveMediaApp {

    /**
     * [0] type of migration - db, images
     * [1] from where - fs, db
     *
     */

    public static void main(String[] args){

        String migrationType = args[0];

        MigrationSettings migrationSettings = null;
        switch (migrationType){
            case "image":
                migrationSettings = new MediaMigrationSettings();
                break;
            case "db":
                // output: 'not yet implemented'
                System.exit(0);
                break;
            default:
                // output: 'unknown migration type'
                System.exit(0);
                break;
        }

        // evaluate further user input parameters and store them in the settings object

        String typeOfResource = args[1];    // db, file system etc.
        switch (typeOfResource){
            case "fs":
                if (migrationSettings != null) {
                    if(migrationSettings instanceof MediaMigrationSettings) {
                       ((MediaMigrationSettings) migrationSettings).setFromFileSystem(true);
                    }
                }
                break;
            case "db":
                // output: 'not yet implemented'
                System.exit(0);
                break;
            default:
                // output: 'unknown type of resource'
                System.exit(0);
                break;
        }

    }

}
