package net.almaak.cms.migration.service;

import net.almaak.cms.migration.dao.Image;

import java.io.File;
import java.util.List;

/**
 * Handles joomla images
 *
 * @author leiferksn
 * @version %I%, %G%
 */

public interface ImageLoaderService {

    Image loadImageFromFileName(final String fileName);
    List<Image> loadImagesFromFileSystemPath(final String fsPath, long limit);    // idk if it works that way for directories

}
