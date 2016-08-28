package dao;

import net.almaak.cms.migration.dao.ArticleDAO;
import net.almaak.cms.migration.dao.entities.Article;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by leiferksn on 6/5/16.
 */
public class ArticleDaoTest {

    private ApplicationContext applicationContext = null;

    private ArticleDAO articleDAO;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("/applicationContext-test.xml");
        articleDAO = (ArticleDAO) applicationContext.getBean("imageReferenceDao");
    }

    @After
    public void tearDown(){
        applicationContext = null;
    }

    @Test
    public void shouldReturnAllImageReferences(){
        List<Article> articles =  articleDAO.loadAll();
        Assert.assertTrue(articles != null);
        Assert.assertTrue(articles.size() > 0);
        boolean checkImagesExist = false;
        boolean checkTitleExists = true;
        boolean checkAliasExists = true;
        boolean checkIdExists = true;
        for (Article article : articles) {
            checkAliasExists = checkMemberValidity(article.getArticleAlias());
            if(!checkAliasExists) {
                break;
            }

            checkTitleExists =  checkMemberValidity(article.getArticleName());
            if (!checkTitleExists) {
                break;
            }

            if (article.getImages().size() > 0) {
                checkImagesExist = true;
                break;
            }
        }
        Assert.assertTrue(checkAliasExists);
        Assert.assertTrue(checkTitleExists);
        Assert.assertTrue(checkImagesExist);
    }

    private boolean checkMemberValidity(final String memberValue) {
        if (memberValue == null || (memberValue != null && memberValue.length() <= 0)) {
            return false;
        }
        return true;
    }

}
