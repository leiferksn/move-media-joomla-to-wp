package net.almaak.cms.migration.dao;


import net.almaak.cms.migration.dao.entities.mapper.ImageReferenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.List;

/**
 * @author leiferksn
 * @version %I%, %G%
 *
 */
public class ImageReferenceDAOImpl implements ImageReferenceDAO {

    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL = "select id, alias, title, images from jos3_content";

    @Override
    public List loadAll() {
        RowMapper imageReferenceRowMapper = new ImageReferenceMapper();
        List imageReferences = jdbcTemplate.query(SELECT_ALL, imageReferenceRowMapper);
        return imageReferences;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
