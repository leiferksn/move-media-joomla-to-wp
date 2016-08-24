package dao;

import net.almaak.cms.migration.dao.ImageReferenceDAO;
import net.almaak.cms.migration.dao.entities.ImageReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by leiferksn on 6/5/16.
 */
public class ImageReferenceDaoTest {

    private ApplicationContext applicationContext = null;

    private ImageReferenceDAO imageReferenceDAO;

    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("/applicationContext-test.xml");
        imageReferenceDAO = (ImageReferenceDAO) applicationContext.getBean("imageReferenceDao");
    }

    @After
    public void tearDown(){
        applicationContext = null;
    }

    @Test
    public void shouldReturnAllImageReferences(){
        List<ImageReference> imgRefs =  imageReferenceDAO.loadAll();
        Assert.assertTrue(imgRefs != null);
        Assert.assertTrue(imgRefs.size() > 0);
        boolean check = false;
        for (ImageReference ref : imgRefs) {
            if (ref.getImages().size() > 0) {
                check = true;
            }
        }
        Assert.assertTrue(check);
    }

}
