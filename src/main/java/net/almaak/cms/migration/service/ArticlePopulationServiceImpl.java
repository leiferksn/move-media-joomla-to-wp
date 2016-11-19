package net.almaak.cms.migration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.almaak.cms.migration.dao.entities.Article;
import net.almaak.cms.migration.dao.entities.Image;
import net.almaak.cms.migration.dao.entities.mapper.vo.ArticleVO;
import net.almaak.cms.migration.dao.entities.mapper.vo.ImageVO;
import net.almaak.cms.migration.utils.ImageRole;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leiferksn on 11/1/16.
 */
public class ArticlePopulationServiceImpl implements ArticlePopulationService {

    @Autowired
    private ImageLoaderService imageLoaderService;

    @Override
    public Article populateArticle(ArticleVO articleVO) throws IOException {
        Article article = new Article();

        article.setArticleId(articleVO.getArticleId());
        article.setArticleAlias(articleVO.getArticleAlias());
        article.setArticleName(articleVO.getArticleName());
        article.setCreatedBy(articleVO.getCreatedBy());
        article.setCreatedOn(articleVO.getCreatedOn());
        article.setModifiedOn(articleVO.getModifiedOn());
        article.setImages(convertImagesJSONToList(articleVO.getImagesJSON(), article));
        return article;
    }

    private List<Image> convertImagesJSONToList(String imagesJSON, Article article) throws IOException {
        List<Image> imageList = mapImageVOToImage(new ObjectMapper().readValue(imagesJSON, ImageVO.class), article);
        return imageList;
    }

    private List<Image> mapImageVOToImage(ImageVO imageVO, Article article) throws IOException {
        List<Image> imgList = new ArrayList<Image>();

        Image imgIntro = new Image(imageVO.getImageIntro(), imageVO.getImageIntroCaption(),
                imageVO.getImageIntroAlt(), ImageRole.INTRO, retrieveImageData(imageVO.getImageIntro()));
        imgIntro.setArticle(article);
        imgList.add(imgIntro);

        Image imgFulltext = new Image(imageVO.getImageFullText(), imageVO.getImageFulltextCaption(),
                imageVO.getImageFulltextAlt(), ImageRole.FULLTEXT, retrieveImageData(imageVO.getImageFullText()));
        imgFulltext.setArticle(article);
        imgList.add(imgFulltext);

        return imgList;

    }

    private byte[] retrieveImageData(final String imagePath) throws IOException {
        byte[] bytes = null;
        if (imagePath != null) {
            bytes = imageLoaderService.loadImageByFileNameFromFTP(imagePath);
        }
        return bytes;
    }

    public void setImageLoaderService(ImageLoaderService imageLoaderService) {
        this.imageLoaderService = imageLoaderService;
    }
}
