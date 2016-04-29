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

    /**
     * The method converts user's string input parameters to integer values
     *
     * @param strParam app argument
     * @return int value
     */
    private static int convertUserInputParametersToInt(final String strParam) {
        if(strParam.equals("images") || strParam.equals("fs")) {
            return 0;
        }

        if(strParam.equals("db")) {
            return 1;
        }

        return -1;
    }

    /**
     * Entry method
     *
     * @param args user's input parameters
     */
    public static void main(String[] args){

        String migrationType = args[0];

        MigrationSettings migrationSettings = null;
        switch (convertUserInputParametersToInt(migrationType)){
            case 0:
                migrationSettings = new MediaMigrationSettings();
                break;
            case 1:
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
        switch (convertUserInputParametersToInt(typeOfResource)){
            case 0:
                if (migrationSettings != null) {
                    if(migrationSettings instanceof MediaMigrationSettings) {
                       ((MediaMigrationSettings) migrationSettings).setFromFileSystem(true);
                    }
                }
                break;
            case 1:
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
