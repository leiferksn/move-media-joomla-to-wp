package net.almaak.cms.migration.dao.entities;

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


}
