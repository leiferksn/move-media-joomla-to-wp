package net.almaak.cms.migration.dao;


import net.almaak.cms.migration.dao.entities.Image;

import java.io.File;

/**
 *
 *
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public interface ImageDAO {

    Image retrieveImageFromDirectory(final File directory, final String fileName);

}
