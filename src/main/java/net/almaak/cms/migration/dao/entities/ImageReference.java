package net.almaak.cms.migration.dao.entities;

import java.util.List;

/**
 * Represents an image reference in article
 *
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class ImageReference {

    private String articleAlias;
    private String articleName;
    private Long articleId;
    private List<Image> images;


}
