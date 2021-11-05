package org.springframework.learn.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.learn.config.EmbeddedJdbcConfig;
import org.springframework.learn.dao.SingerDao;
import org.springframework.learn.model.Singer;
/**
 * 
 * @author mmarinkovic
 *
 */
public class TestNameParamJdbcTemplate {

	@Test
	public void TestDao() {
		
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(EmbeddedJdbcConfig.class);
		
		assertNotNull(ctx);
		
		SingerDao singerDao = ctx.getBean(SingerDao.class);
		
		assertNotNull(singerDao);

		String bDate="31/12/1998";
		Singer newSinger = new Singer();
		newSinger.setFirstName("Marko");
		newSinger.setLastName("Mikovic");
		try {
			newSinger.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(bDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		singerDao.insert(newSinger);
		
		List<Singer> singers = singerDao.findByFirstName("Marko");
		
		assertEquals(singers.size(), 1);
		
		ctx.close();
	}
}
