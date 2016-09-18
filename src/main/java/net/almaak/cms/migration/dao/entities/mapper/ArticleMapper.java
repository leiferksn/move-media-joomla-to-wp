package net.almaak.cms.migration.dao.entities.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.almaak.cms.migration.dao.entities.Article;
import net.almaak.cms.migration.dao.entities.Image;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ArticleMapper implements RowMapper {

    private static Logger log = Logger.getLogger(ArticleMapper.class);

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();
        try {
            article.setImages(convertImagesJSONToList(rs.getString("images")));
            article.setArticleAlias(rs.getString("alias"));
            article.setArticleId(rs.getLong("id"));
            article.setArticleName(rs.getString("title"));
            article.setCreatedOn(rs.getString("created"));
            article.setModifiedOn(rs.getString("modified"));
            article.setCreatedBy(rs.getString("created_by"));
        } catch (IOException ioe) {
            log.error("Database result can't be mapped to Article");
            throw new SQLException(ioe);
        }
        return article;
    }

    private List<Image> convertImagesJSONToList(String imagesJSON) throws IOException {
        List<Image> imageList = mapImageVOToImage(new ObjectMapper().readValue(imagesJSON, ImageVO.class));
        return imageList;
    }

    private List<Image> mapImageVOToImage(ImageVO imageVO) {
        List<Image> imgList = new ArrayList<Image>();

        Image imgIntro = new Image(imageVO.getImageIntro(), imageVO.getImageIntroCaption(),
                imageVO.getImageIntroAlt(), ImageRole.INTRO, null);

        imgList.add(imgIntro);

        Image imgFulltext = new Image(imageVO.getImageFullText(), imageVO.getImageFulltextCaption(),
                imageVO.getImageFulltextAlt(), ImageRole.FULLTEXT, null);

        imgList.add(imgFulltext);
        return imgList;

    }
}
