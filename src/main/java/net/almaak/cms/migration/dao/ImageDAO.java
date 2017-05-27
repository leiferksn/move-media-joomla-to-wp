package net.almaak.cms.migration.dao;


import net.almaak.cms.migration.dao.entities.SourceImage;

import java.io.File;

/**
 *
 *
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public interface ImageDAO {

    SourceImage retrieveImageFromDirectory(final File directory, final String fileName);

}
