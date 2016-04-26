package net.almaak.cms.migration.service;

import net.almaak.cms.migration.settings.MediaMigrationSettings;
import net.almaak.cms.migration.settings.MigrationSettings;

/**
 * Created by leiferksn on 4/26/16.
 * @author leiferksn
 * @version %I%, %G%
 */

public interface MigrationService {

    boolean migrateImages(final MediaMigrationSettings mediaMigrationSettings);
    boolean migrateDatabase(final MigrationSettings migrationSettings);

}
