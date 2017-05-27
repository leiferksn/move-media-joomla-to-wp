package net.almaak.cms.migration.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.almaak.cms.migration.dao.entities.SourceArticle;
import net.almaak.cms.migration.dao.entities.SourceImage;
import net.almaak.cms.migration.dao.entities.mapper.vo.SourceArticleVO;
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
    public SourceArticle populateArticle(SourceArticleVO sourceArticleVO) throws IOException {
        SourceArticle sourceArticle = new SourceArticle();

        sourceArticle.setArticleId(sourceArticleVO.getArticleId());
        sourceArticle.setArticleAlias(sourceArticleVO.getArticleAlias());
        sourceArticle.setArticleName(sourceArticleVO.getArticleName());
        sourceArticle.setCreatedBy(sourceArticleVO.getCreatedBy());
        sourceArticle.setCreatedOn(sourceArticleVO.getCreatedOn());
        sourceArticle.setModifiedOn(sourceArticleVO.getModifiedOn());
        sourceArticle.setSourceImages(convertImagesJSONToList(sourceArticleVO.getImagesJSON(), sourceArticle));
        return sourceArticle;
    }

    private List<SourceImage> convertImagesJSONToList(String imagesJSON, SourceArticle sourceArticle) throws IOException {
        List<SourceImage> sourceImageList = mapImageVOToImage(new ObjectMapper().readValue(imagesJSON, ImageVO.class), sourceArticle);
        return sourceImageList;
    }

    private List<SourceImage> mapImageVOToImage(ImageVO imageVO, SourceArticle sourceArticle) throws IOException {
        List<SourceImage> imgList = new ArrayList<SourceImage>();

        SourceImage imgIntro = new SourceImage(imageVO.getImageIntro(), imageVO.getImageIntroCaption(),
                imageVO.getImageIntroAlt(), ImageRole.INTRO, retrieveImageData(imageVO.getImageIntro()));
        imgIntro.setSourceArticle(sourceArticle);
        imgList.add(imgIntro);

        SourceImage imgFulltext = new SourceImage(imageVO.getImageFullText(), imageVO.getImageFulltextCaption(),
                imageVO.getImageFulltextAlt(), ImageRole.FULLTEXT, retrieveImageData(imageVO.getImageFullText()));
        imgFulltext.setSourceArticle(sourceArticle);
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
