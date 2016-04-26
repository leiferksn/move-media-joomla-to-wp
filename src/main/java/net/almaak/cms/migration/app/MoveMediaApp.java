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
     * [0] type of migration - 0 (DB), (1) images etc
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

        // evaluate further user input parameters and store them in setting object


    }

}
