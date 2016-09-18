package net.almaak.cms.migration.dao;


import net.almaak.cms.migration.dao.entities.mapper.ArticleMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class ArticleDAOImpl implements ArticleDAO {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "select id, alias, title, images, created, modified, created_by from jos3_content";

    @Override
    public List loadAll() {
        RowMapper articleRowMapper = new ArticleMapper();
        List articles = jdbcTemplate.query(SELECT_ALL, articleRowMapper);
        return articles;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
