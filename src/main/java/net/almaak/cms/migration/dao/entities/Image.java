package net.almaak.cms.migration.dao.entities;

import net.almaak.cms.migration.utils.ImageRole;

/**
 * Represents an image resource
 *
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class Image extends Media {

    private String imagePath;
    private String imageCaption;
    private String imageAlt;
    private byte[] imageData;
    private ImageRole imageRole;


    public Image (String aImagePath,
                  String aImageCaption,
                  String aImageAlt,
                  ImageRole aImageRole,
                  byte[] aImageData) {
        this.imagePath = aImagePath;
        this.imageCaption = aImageCaption;
        this.imageAlt = aImageAlt;
        this.imageRole = aImageRole;
        this.imageData = aImageData;

    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }


    public ImageRole getImageRole() {
        return imageRole;
    }

    public void setImageRole(ImageRole imageRole) {
        this.imageRole = imageRole;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImageCaption() {
        return imageCaption;
    }

    public void setImageCaption(String imageCaption) {
        this.imageCaption = imageCaption;
    }

    public String getImageAlt() {
        return imageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.imageAlt = imageAlt;
    }
}
