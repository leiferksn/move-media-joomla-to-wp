package net.almaak.cms.migration.service;

import net.almaak.cms.migration.dao.entities.SourceArticle;
import net.almaak.cms.migration.dao.entities.mapper.vo.SourceArticleVO;

import java.io.IOException;

/**
 * Created by leiferksn on 11/1/16.
 */
public interface ArticlePopulationService {

    SourceArticle populateArticle(final SourceArticleVO sourceArticleVO) throws IOException;

}
