package net.almaak.cms.migration.dao.entities.mapper.vo;

/**
 * Created by leiferksn on 11/1/16.
 *
 */

public class SourceArticleVO {

    private String articleAlias;
    private String articleName;
    private Long articleId;
    private String createdOn;
    private String modifiedOn;
    private String createdBy;
    private String imagesJSON;

    public String getArticleAlias() {
        return articleAlias;
    }

    public void setArticleAlias(String articleAlias) {
        this.articleAlias = articleAlias;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
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

    public String getImagesJSON() {
        return imagesJSON;
    }

    public void setImagesJSON(String imagesJSON) {
        this.imagesJSON = imagesJSON;
    }
}
