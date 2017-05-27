package dao;

import net.almaak.cms.migration.dao.SourceArticleDAO;
import net.almaak.cms.migration.dao.entities.mapper.vo.SourceArticleVO;
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
public class SourceSourceArticleDaoTest {

    private ApplicationContext applicationContext = null;

    private SourceArticleDAO sourceArticleDAO;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("/applicationContext-test.xml");
        sourceArticleDAO = (SourceArticleDAO) applicationContext.getBean("imageReferenceDao");
    }

    @After
    public void tearDown(){
        applicationContext = null;
    }

    @Test
    public void shouldReturnAllImageReferences(){
        List<SourceArticleVO> articles =  sourceArticleDAO.loadAll();
        Assert.assertTrue(articles != null);
        Assert.assertTrue(articles.size() > 0);
        boolean checkImagesExist = false;
        boolean checkTitleExists = true;
        boolean checkAliasExists = true;
        boolean checkIdExists = true;
        for (SourceArticleVO article : articles) {
            checkIdExists = checkMemberValidity(article.getArticleId().toString());
            if(!checkIdExists){
                break;
            }

            checkAliasExists = checkMemberValidity(article.getArticleAlias());
            if(!checkAliasExists) {
                break;
            }

            checkTitleExists =  checkMemberValidity(article.getArticleName());
            if (!checkTitleExists) {
                break;
            }

            if (article.getImagesJSON().length() > 0) {
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
