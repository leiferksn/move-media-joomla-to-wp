package net.almaak.cms.migration.service;


import net.almaak.cms.migration.dao.entities.Image;
import net.almaak.cms.migration.utils.FtpUtility;

import java.util.List;

public class ImageLoaderServiceImpl implements ImageLoaderService {


    /**
     * Should be transactional
     *
     * @param fileName
     * @param remoteRessource
     * @return
     */
    @Override
    public Image loadImageByFileNameFromFTP(String fileName, String remoteRessource) {
        return null;
    }

    @Override
    public List<Image> loadImagesFromFileSystemPath(String fsPath, long limit) {
        List<String> fileList = FtpUtility.getInstance().retrieveFileListFromFtpResource(fsPath);

        /**
         *  load only @limit of files into a list, which preserves order,
         *  so that we can load the files in portions
         **/

        if(fileList != null) {

        }
        return null;
    }
}
