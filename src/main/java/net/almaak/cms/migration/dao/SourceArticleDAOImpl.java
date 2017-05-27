package net.almaak.cms.migration.dao;


import net.almaak.cms.migration.dao.entities.mapper.SourceArticleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class SourceArticleDAOImpl implements SourceArticleDAO {

    private JdbcTemplate sourceJdbcTemplate;

    private static final String SELECT_ALL = "select id, alias, title, images, created, modified, created_by from jos3_content";

    @Override
    public List loadAll() {
        RowMapper articleRowMapper = new SourceArticleMapper();
        List articles = sourceJdbcTemplate.query(SELECT_ALL, articleRowMapper);
        return articles;
    }



    public void setSourceJdbcTemplate(JdbcTemplate sourceJdbcTemplate) {
        this.sourceJdbcTemplate = sourceJdbcTemplate;
    }
}
