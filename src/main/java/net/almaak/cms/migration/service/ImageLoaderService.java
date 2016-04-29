package net.almaak.cms.migration.service;

import net.almaak.cms.migration.dao.entities.Image;

import java.util.List;

/**
 * Handles joomla images
 *
 * @author leiferksn
 * @version %I%, %G%
 */

public interface ImageLoaderService {

    Image loadImageByFileNameFromFTP(final String fileName, String remoteRessource);
    List<Image> loadImagesFromFileSystemPath(final String fsPath, long limit);    // idk if it works that way for directories

}
