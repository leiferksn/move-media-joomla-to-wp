package net.almaak.cms.migration.service;


import net.almaak.cms.migration.dao.entities.Image;
import net.almaak.cms.migration.settings.MigrationSettings;
import net.almaak.cms.migration.utils.FtpUtility;

import java.io.IOException;
import java.util.List;

public class ImageLoaderServiceImpl implements ImageLoaderService {

    /**
     * Loads image data from ftp given a path
     *
     * @param fileName relative path to the file
     * @return
     */
    @Override
    public byte[] loadImageByFileNameFromFTP(String fileName) throws IOException {
        MigrationSettings ms = MigrationSettings.getInstance();
        FtpUtility ftpUtility = new FtpUtility(ms.getFtpServer(), ms.getFtpUsername(), ms.getFtpPassword());
        return ftpUtility.retrieveFileFromFtpResource(fileName);
    }

    @Override
    public List<Image> loadImagesFromFileSystemPath(String fsPath, long limit) {
        /*
        List<String> fileList = FtpUtility.getInstance().retrieveFileListFromFtpResource(fsPath);
        */
        /**
         *  load only @limit of files into a list, which preserves order,
         *  so that we can load the files in portions
         **/
        /*
        if(fileList != null) {

        } */
        return null;
    }
}
