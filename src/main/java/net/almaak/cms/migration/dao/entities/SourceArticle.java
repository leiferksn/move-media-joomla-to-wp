package net.almaak.cms.migration.dao.entities;

import java.util.List;

/**
 * Represents an image reference in article
 *
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class SourceArticle {

    private String articleAlias;
    private String articleName;
    private Long articleId;
    private String createdOn;
    private String modifiedOn;
    private String createdBy;
    private List<SourceImage> sourceImages;

    public void setArticleAlias(String articleAlias) {
        this.articleAlias = articleAlias;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setSourceImages(List<SourceImage> sourceImages) {
        this.sourceImages = sourceImages;
    }

    public String getArticleAlias() {
        return articleAlias;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getArticleName() {
        return articleName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public List<SourceImage> getSourceImages() {
        return sourceImages;
    }
}
