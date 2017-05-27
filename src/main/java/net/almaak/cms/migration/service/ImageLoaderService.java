package net.almaak.cms.migration.service;

import net.almaak.cms.migration.dao.entities.SourceImage;

import java.io.IOException;
import java.util.List;

/**
 * Handles joomla images
 *
 * @author leiferksn
 * @version %I%, %G%
 */

public interface ImageLoaderService {

    byte[] loadImageByFileNameFromFTP(final String fileName) throws IOException;
    List<SourceImage> loadImagesFromFileSystemPath(final String fsPath, long limit);    // idk if it works that way for directories

}
