package net.almaak.cms.migration.dao.entities;

import java.util.List;

/**
 * Represents an image reference in article
 *
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class Article {

    private String articleAlias;
    private String articleName;
    private Long articleId;
    private List<Image> images;

    public void setArticleAlias(String articleAlias) {
        this.articleAlias = articleAlias;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getArticleAlias() {
        return articleAlias;
    }

    public String getArticleName() {
        return articleName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public List<Image> getImages() {
        return images;
    }
}
