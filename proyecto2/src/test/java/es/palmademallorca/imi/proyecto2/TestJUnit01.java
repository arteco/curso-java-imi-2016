package es.palmademallorca.imi.proyecto2;

import es.palmademallorca.imi.proyecto2.dto.PersonDto;
import es.palmademallorca.imi.proyecto2.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Developed by Arteco Consulting Sl.
 * Author rarnau on 4/11/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("devel")
public class TestJUnit01 {

    private static final Logger logger = LoggerFactory.getLogger(TestJUnit01.class);


    @Autowired
    private PersonService personDao;

    @Test
    public void contextLoads() {
        List<PersonDto> people = personDao.getPeople();
        Assert.assertTrue(people.size() > 0);
        logger.info("Test finalizado");
    }

}
