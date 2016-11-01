package net.almaak.cms.migration.service;

import net.almaak.cms.migration.dao.entities.Article;
import net.almaak.cms.migration.dao.entities.mapper.vo.ArticleVO;

import java.io.IOException;

/**
 * Created by leiferksn on 11/1/16.
 */
public interface ArticlePopulationService {

    Article populateArticle(final ArticleVO articleVO) throws IOException;

}
