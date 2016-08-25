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
        List<Article> imgRefs =  articleDAO.loadAll();
        Assert.assertTrue(imgRefs != null);
        Assert.assertTrue(imgRefs.size() > 0);
        boolean check = false;
        for (Article ref : imgRefs) {
            if (ref.getImages().size() > 0) {
                check = true;
            }
        }
        Assert.assertTrue(check);
    }

}
