package net.almaak.cms.migration.dao.entities.mapper;

import net.almaak.cms.migration.dao.entities.mapper.vo.SourceArticleVO;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SourceArticleMapper implements RowMapper {

    private static Logger log = Logger.getLogger(SourceArticleMapper.class);

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        SourceArticleVO article = new SourceArticleVO();
        // article.setSourceImages(convertImagesJSONToList(rs.getString("images")));
        article.setImagesJSON(rs.getString("images"));
        article.setArticleAlias(rs.getString("alias"));
        article.setArticleId(rs.getLong("id"));
        article.setArticleName(rs.getString("title"));
        article.setCreatedOn(rs.getString("created"));
        article.setModifiedOn(rs.getString("modified"));
        article.setCreatedBy(rs.getString("created_by"));
        return article;
    }
}
