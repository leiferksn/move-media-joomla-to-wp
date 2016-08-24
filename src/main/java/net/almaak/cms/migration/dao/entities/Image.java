package net.almaak.cms.migration.dao.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an image resource
 *
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class Image extends Media {

    private byte[] imageData;
    private List<ImageReference> referencesToArticle;
    private String imageRole;

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public List<ImageReference> getReferencesToArticle() {
        return referencesToArticle;
    }

    public void setReferencesToArticle(List<ImageReference> referencesToArticle) {
        this.referencesToArticle = referencesToArticle;
    }

    public String getImageRole() {
        return imageRole;
    }

    public void setImageRole(String imageRole) {
        this.imageRole = imageRole;
    }

    public void addImageReference(final ImageReference imgReference) {
        if(referencesToArticle == null ) {
            referencesToArticle = new ArrayList<ImageReference>();
        }
        referencesToArticle.add(imgReference);
    }
}
